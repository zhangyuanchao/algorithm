package com.greece.prometheus.graph;

/**
 * ���鼯(�����ཻ�ü���)
 * ����ֱ��:UnionFindSet
 *
 */
public class DisjointSet {
	
	private int[] parent; // ��¼ÿ����ĸ��ڵ�id
	
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
