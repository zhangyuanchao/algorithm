package com.greece.prometheus.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	
	// k��ı�ţ�vʵ�ʵĵ�
	public HashMap<Integer, Node> nodes; // �㼯
	public HashSet<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}

}
