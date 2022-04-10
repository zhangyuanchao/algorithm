package com.greece.prometheus.graph;

import java.util.Collection;
import java.util.HashMap;

public class UnionFind {
	private HashMap<Node, Node> fatherMap;
	private HashMap<Node, Integer> rankMap;
	public UnionFind() {
		fatherMap = new HashMap<>();
		rankMap = new HashMap<>();
	}
	public Node findFather(Node n) {
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
			fatherMap.put(node, node);
			rankMap.put(node, 1);
		}
	}
	public boolean isSameSet(Node a, Node b) {
		return findFather(a) == findFather(b);
	}
	public void union(Node a, Node b) {
		if (a == null || b == null) return;
		Node af = fatherMap.get(a);
		Node bf = fatherMap.get(b);
		if (af != bf) { // a b不在同一集合
			int ar = rankMap.get(af);
			int br = rankMap.get(bf);
			if (ar <= br) {// a和b所在集合，哪个根节点的权重值大，则将权重大的根节点作为a和b所在集合新的根节点，根节点相同，a和b所在集合完成合并
				fatherMap.put(af, bf);
				rankMap.put(bf, ar + br);
			} else {
				fatherMap.put(bf, af);
				rankMap.put(af, ar + br);
			}
		}
	}

}
