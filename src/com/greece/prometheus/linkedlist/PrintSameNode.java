package com.greece.prometheus.linkedlist;

public class PrintSameNode {
	
	public static class Node {
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static Node createList(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		Node head = new Node(0);
		Node cur = head;
		for (int i = 0; i < arr.length; i++) {
			cur.next = new Node(arr[i]);
			cur = cur.next;
		}
		return head.next;
	}
	
	public static void addNode(Node head, Node n) {
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = n;
	}
	
	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 3, 4, 7, 9};
		Node ah = createList(a);
		int[] b = {2, 3, 6, 8, 9};
		Node bh = createList(b);
		Node p1 = ah;
		Node p2 = bh;
		Node theSameNodeList = null;;
		while (p1!= null && p2 != null) {
			if (p1.value < p2.value) {
				p1 = p1.next;
			} else if (p1.value > p2.value) {
				p2 = p2.next;
			} else {
				if (theSameNodeList == null) {
					theSameNodeList = new Node(p1.value);
				} else {
					addNode(theSameNodeList, new Node(p1.value));
				}
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		printList(theSameNodeList);
	}

}
