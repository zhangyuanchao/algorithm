package com.greece.prometheus.bd;

public class BinarySearchTree {

	private class Node {

		int data; // 数据域
		BinarySearchTree.Node right; // 右孩子
		BinarySearchTree.Node left; // 左孩子
	}

	private Node root; // 根节点

	private void insert(int key) {
		Node p = new Node();
		p.data = key;

		if (root == null) {
			root = p;
		} else {
			Node parent = new Node();
			Node current = root;
			while (true) {
				parent = current;
				if (key > current.data) {
					current = current.right;
					if (current == null) {
						parent.right = p;
						return;
					}
				} else {
					current = current.left;
					if (current == null) {
						parent.left = p;
						return;
					}
				}
			}
		}
	}

	public void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public void postOrder(Node root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
