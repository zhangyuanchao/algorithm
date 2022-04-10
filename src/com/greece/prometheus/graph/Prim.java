package com.greece.prometheus.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
	
	public static class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.weight - o2.weight;
		}
		
	}
	
	public static Set<Edge> primMST(Graph graph) {
		// �����ı߽���С����
		PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
		
		HashSet<Node> set = new HashSet<>();
		
		Set<Edge> result = new HashSet<>(); // ������ѡ�ı���result��
		
		for (Node node : graph.nodes.values()) { // �����ѡ��һ����
			// node�ǿ�ʼ��
			if (!set.contains(node)) {
				set.add(node);
				for (Edge edge : node.edges) { // ��һ����������������ı�
					priorityQueue.add(edge);
				}
				while (!priorityQueue.isEmpty()) {
					Edge edge = priorityQueue.poll(); // ���������ı�����С�ı�
					Node toNode = edge.to;
					if (!set.contains(toNode)) { // �����е�ʱ������µĵ�
						set.add(toNode);
						result.add(edge);
						for (Edge nextEdge : toNode.edges) {
							priorityQueue.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
		
	}

}
