package com.greece.prometheus.binarytree;

import java.util.Stack;

public class BinaryTreeTraverse {
	
	public static class Node {
		public int data; // 数据域
		public Node left; // 左指针域
		public Node right; // 右指针域
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void printTreeNodeRecur(Node head) {
		if (head == null) {
			return;
		}
		// System.out.println(head.data);
		printTreeNodeRecur(head.left);
		// System.out.println(head.data);
		printTreeNodeRecur(head.right);
		System.out.println(head.data);
	}
	
	/**
	 * 非递归前序遍历(头、左、右)
	 * 1、先将头节点压栈
	 * 2、从栈中弹出一个节点cur
	 * 3、打印(处理)该节点
	 * 4、先右、再左(如果有)
	 * 5、重复1-4
	 * @param head
	 */
	public static void preOrderUnRecur(Node head) {
		System.out.println("pre-order:");
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.data + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	
	/**
	 * 非递归中序遍历(左、头、右)
	 * 先将一棵树的左边界入栈，然后再弹出，如果有右子树，则处理右子树
	 * @param head
	 */
	public static void inOrderUnRecur(Node head) {
		System.out.println("in-order:");
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.println(head.data + " ");
					head = head.right;
				}
			}
		}
	}
	
	public static void inOrderUnRecur1(Node head) {
		System.out.println("in-order:");
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.println(head.data + " ");
					head = head.right;
				}
			}
		}
	}
	
	/**
	 * 非递归后序遍历(左、右、头)
	 * 在非递归前序遍历中，先压栈左子树，再压栈右子树，得到的顺序是头、右、左
	 * 再借助栈反转头、右、左 ---> 左、右、头，即得到后序
	 * @param head
	 */
	public static void posOrderUnRecur(Node head) {
		System.out.println("pos-order:");
		if (head != null) {
			Stack<Node> s1 = new Stack<>();
			Stack<Node> s2 = new Stack<>();
			s1.add(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.add(head);
				if (head.left != null) {
					s1.add(head.left);
				}
				if (head.right != null) {
					s1.add(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.println(s2.pop().data + " ");
			}
		}
	}
	
	public static Node createTreeNode(Integer[] array, int index) {
		if (index > array.length) {
			return null;
		}
		Integer value = array[index-1];
		if (value == null) {
			return null;
		}
		Node node = new Node(value);
		node.left = createTreeNode(array, 2*index);
		node.right = createTreeNode(array, 2*index + 1);
		return node;
	}
	
	/**
	 * 判断一棵树是完全二叉树
	 * 1、任意一节点，有右无左，false
	 * 2、在满足1的情况下，如果遇到第一个左右子不全，则后续的节点全是叶子节点
	 * 使用宽度优先遍历(队列)
	 * @param args
	 */
	
	/**
	 * 1、一棵树是否是搜索二叉树
	 * 2、一棵树是否是完全二叉树
	 * 3、一棵树是否是满二叉树
	 * 4、一棵树是否是平衡二叉树
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1, 2, 3, 4, 5, 6, 7};
		Node head = createTreeNode(array, 1);
		// printTreeNodeRecur(head);
		// preOrderUnRecur(head);
		// posOrderUnRecur(head);
		/***************************************/
		posOrderUnRecur(head);
	}

}
