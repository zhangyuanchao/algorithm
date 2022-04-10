package com.greece.prometheus.graph;

/**
 * 并查集(互不相交得集合)
 * 中文直译:UnionFindSet
 *
 */
public class DisjointSet {
	
	private int[] parent; // 记录每个点的父节点id
	
	public DisjointSet(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("size is error!");
		}
		parent = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}
	
	public int getParent(int x) {
		if (x < 0 || x > parent.length) {
			throw new IllegalArgumentException("x is out of bound!");
		}
		return parent[x] == x ? x : getParent(parent[x]);
	}
	
	public void merge(int m, int n) {
		int mp = getParent(m);
		int np = getParent(n);
		if (mp == np) {
			return;
		}
		parent[mp] = np;
	}
	
	public boolean isConnected(int m, int n) {
		return getParent(m) == getParent(n);
	}

}
