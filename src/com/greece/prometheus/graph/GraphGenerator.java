package com.greece.prometheus.graph;

public class GraphGenerator {
	
	public static Graph createGraph(int[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			int from = matrix[i][0];
			int to = matrix[i][1];
			int weight = matrix[i][2];
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge edge = new Edge(weight, fromNode, toNode);
			fromNode.out++;
			fromNode.nexts.add(toNode);
			toNode.in++;
			fromNode.edges.add(edge);
			graph.edges.add(edge);
		}
		return graph;
	}

}
