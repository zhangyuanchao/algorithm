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
		if (af != bf) { // a b����ͬһ����
			int ar = rankMap.get(af);
			int br = rankMap.get(bf);
			if (ar <= br) {// a��b���ڼ��ϣ��ĸ����ڵ��Ȩ��ֵ����Ȩ�ش�ĸ��ڵ���Ϊa��b���ڼ����µĸ��ڵ㣬���ڵ���ͬ��a��b���ڼ�����ɺϲ�
				fatherMap.put(af, bf);
				rankMap.put(bf, ar + br);
			} else {
				fatherMap.put(bf, af);
				rankMap.put(af, ar + br);
			}
		}
	}

}
