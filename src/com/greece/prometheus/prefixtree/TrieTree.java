package com.greece.prometheus.prefixtree;

/**
 * 前缀树
 */
public class TrieTree {
	
	public static class TrieNode {
		public int pass; // 通过当前节点的次数
		public int end; // 以当前节点为结束点的次数
		// HashMap<Char, Node> nexts;
		// TreeMap<Char, Node> nexts;
		public TrieNode[] nexts;
		
		public TrieNode() {
			pass = 0;
			end = 0;
			// nexts[0] == null, 没有走向'a'的路
			// nexts[0] != null, 有走向'a'的路
			// nexts[25] != null, 有走向'z'的路
			nexts = new TrieNode[26];
		}
	}
	
	public static class Trie {
		public static char startChar = 'a';
		// root节点的pass表示当前前缀树中加入了多少个字符串，
		// 也表示以""(空字符)为前缀的字符串有多少个
		public TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		// 向前缀树中增加字符串word
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			node.pass++;
			int index = 0;
			for (int i = 0; i < chs.length; i++) { // 从左往右遍历字符
				index = chs[i] - startChar; // 由字符对应走向哪条路
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.pass++;
			}
			node.end++;
		}
		
		// 从前缀树中删除字符串word
		public void delete(String word) {
			if (search(word) != 0) { // 加入过word才能删除
				char[] chs = word.toCharArray();
				TrieNode node = root;
				node.pass--; // 根节点pass--，表示从整棵前缀树中删除一个字符串
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - startChar;
					if (node.nexts[index] != null) {
						node.nexts[index].pass--;
						if (node.nexts[index].pass == 0) {
							// C++需要遍历到底去析构
							node.nexts[index] = null;
							return;
						}
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}
		
		
		public void delete1(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			node.pass--;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - startChar;
				if (node.nexts[index] != null) {
					node.nexts[index].pass--;
					if (node.nexts[index].nexts == null) {
						node.nexts[index].end = 0;
					}
					if (node.nexts[index].pass == 0) {
						node.nexts[index] = null;
					}
					node = node.nexts[index];
				}
			}
		}
		
		// word这个单词之前加入过几次
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - startChar;
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
		
		// 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - startChar;
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.pass;
		}
		
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.delete("abc");
		TrieNode root = trie.root;
		System.out.println("end");
	}

}
