package com.greece.prometheus.linkedlist;

import java.util.Stack;

public class IsPalindromeList {
	
	public static class Node {
		public int value;
		public Node next;
		
		public Node (int data) {
			this.value = data;
		}
	}
	
	public static boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	public static boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head; // slow
		Node n2 = head; // fast
		while (n2.next != null && n2.next.next != null) {
			n1 = n1.next; // n1 -> mid
			n2 = n2.next.next; // n2 -> end
		}
		// 逆序右半链表
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while (n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		// 逆序完n3为逆序后右半链表头节点，也是原始链表最后一个节点
		n3 = n1; // n1从右向左
		n2 = head; // n2从左向右
		boolean res = true;
		while (n1 != null && n2 != null) {
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		// 再次逆序右边链表, 还原为原始链表
		n1 = n3.next;
		n3.next = null;
		while (n3 != null) {
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
