package com.greece.prometheus.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	
	// k点的编号，v实际的点
	public HashMap<Integer, Node> nodes; // 点集
	public HashSet<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}

}
