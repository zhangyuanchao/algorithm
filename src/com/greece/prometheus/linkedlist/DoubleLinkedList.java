package com.greece.prometheus.linkedlist;

public class DoubleLinkedList {
	
	public class Node {
		public Integer data;// 数据域
		public Node prev; // 前置指针
		public Node next; // 后置指针
		
		public Node() {
			
		}
		public Node(Integer data) {
			this.data = data;
		}
	}
	
	Node reverseList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node current = head.next; // 指向第一个节点
		Node next = current.next; // 指向第二个节点
		current.next = null; // 第一个节点与后续节点断开
		Node prev = null;
		while (next != null) {
			prev = next.next;
			next.prev = null;
			current.prev = next;
			current = next; // 使下一个节点成为当前节点
			next = prev;
		}
		current.prev = head; // 将最后一个节点的前置节点赋值为头节点指针
		head.next = current; // 将头节点与后置节点连接
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
