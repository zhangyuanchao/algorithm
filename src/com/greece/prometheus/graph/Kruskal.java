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
		private HashMap<Node, Node> fatherMap; // 节点所在集合的根节点
		private HashMap<Node, Integer> rankMap; // 根节点的权重值(所在集合的节点个数)，在合并集合的时候使用 

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
				fatherMap.put(node, node); // 初始时每个节点所在集合的根节点是本身
				rankMap.put(node, 1);
			}
		}

		public boolean isSameSet(Node a, Node b) {
			return findFather(a) == findFather(b);
		}
		
		// 合并两个节点所在的集合
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aFather = findFather(a);
			Node bFather = findFather(b);
			if (aFather != bFather) { // a和b所在集合的根节点不同，说明a和b不在同一集合，需要合并
				int aFrank = rankMap.get(aFather);
				int bFrank = rankMap.get(bFather);
				// a和b所在集合，哪个根节点的权重值大，则将权重大的根节点作为a和b所在集合新的根节点，
				// 根节点相同，a和b所在集合完成合并
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
		UnionFind unionFind = new UnionFind();//生成一个并查集
		unionFind.makeSets(graph.nodes.values());
		//生成一个优先级队列（堆）
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
