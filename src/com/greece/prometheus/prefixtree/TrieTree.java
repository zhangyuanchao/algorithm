package com.greece.prometheus.prefixtree;

/**
 * ǰ׺��
 */
public class TrieTree {
	
	public static class TrieNode {
		public int pass; // ͨ����ǰ�ڵ�Ĵ���
		public int end; // �Ե�ǰ�ڵ�Ϊ������Ĵ���
		// HashMap<Char, Node> nexts;
		// TreeMap<Char, Node> nexts;
		public TrieNode[] nexts;
		
		public TrieNode() {
			pass = 0;
			end = 0;
			// nexts[0] == null, û������'a'��·
			// nexts[0] != null, ������'a'��·
			// nexts[25] != null, ������'z'��·
			nexts = new TrieNode[26];
		}
	}
	
	public static class Trie {
		public static char startChar = 'a';
		// root�ڵ��pass��ʾ��ǰǰ׺���м����˶��ٸ��ַ�����
		// Ҳ��ʾ��""(���ַ�)Ϊǰ׺���ַ����ж��ٸ�
		public TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		// ��ǰ׺���������ַ���word
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			node.pass++;
			int index = 0;
			for (int i = 0; i < chs.length; i++) { // �������ұ����ַ�
				index = chs[i] - startChar; // ���ַ���Ӧ��������·
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.pass++;
			}
			node.end++;
		}
		
		// ��ǰ׺����ɾ���ַ���word
		public void delete(String word) {
			if (search(word) != 0) { // �����word����ɾ��
				char[] chs = word.toCharArray();
				TrieNode node = root;
				node.pass--; // ���ڵ�pass--����ʾ������ǰ׺����ɾ��һ���ַ���
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - startChar;
					if (node.nexts[index] != null) {
						node.nexts[index].pass--;
						if (node.nexts[index].pass == 0) {
							// C++��Ҫ��������ȥ����
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
		
		// word�������֮ǰ���������
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
		
		// ���м�����ַ����У��м�������pre����ַ�����Ϊǰ׺��
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
