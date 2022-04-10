package com.greece.prometheus.graph;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//undirected graph only
public class Kruskal {
	
	// Union-Find Set
	public static class UnionFind {
		private HashMap<Node, Node> fatherMap; // �ڵ����ڼ��ϵĸ��ڵ�
		private HashMap<Node, Integer> rankMap; // ���ڵ��Ȩ��ֵ(���ڼ��ϵĽڵ����)���ںϲ����ϵ�ʱ��ʹ�� 

		public UnionFind() {
			fatherMap = new HashMap<Node, Node>();
			rankMap = new HashMap<Node, Integer>();
		}

		private Node findFather(Node n) {
			Node father = fatherMap.get(n);
			if (father != n) {
				father = findFather(father);
			}
			fatherMap.put(n, father);
			return father;
		}

		public void makeSets(Collection<Node> nodes) {
			fatherMap.clear();
			rankMap.clear();
			for (Node node : nodes) {
				fatherMap.put(node, node); // ��ʼʱÿ���ڵ����ڼ��ϵĸ��ڵ��Ǳ���
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}
		
		// �ϲ������ڵ����ڵļ���
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) { // a��b���ڼ��ϵĸ��ڵ㲻ͬ��˵��a��b����ͬһ���ϣ���Ҫ�ϲ�
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				// a��b���ڼ��ϣ��ĸ����ڵ��Ȩ��ֵ����Ȩ�ش�ĸ��ڵ���Ϊa��b���ڼ����µĸ��ڵ㣬
				// ���ڵ���ͬ��a��b���ڼ�����ɺϲ�
				if (aFrank <= bFrank) {
					fatherMap.put(aFather, bFather); // 
					rankMap.put(bFather, aFrank + bFrank);
				} else {
					fatherMap.put(bFather, aFather);
					rankMap.put(aFather, aFrank + bFrank);
				}
			}
		}
	}

	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}

	}

	public static Set<Edge> kruskalMST(Graph graph) {
		UnionFind unionFind = new UnionFind();//����һ�����鼯
		unionFind.makeSets(graph.nodes.values());
		//����һ�����ȼ����У��ѣ�
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		for (Edge edge : graph.edges) {
			priorityQueue.add(edge);
		}
		Set<Edge> result = new HashSet<>();
		while (!priorityQueue.isEmpty()) {
			Edge edge = priorityQueue.poll();
			if (!unionFind.isSameSet(edge.from, edge.to)) {
				result.add(edge);
				unionFind.union(edge.from, edge.to);
			}
		}
		return result;
	}

}
