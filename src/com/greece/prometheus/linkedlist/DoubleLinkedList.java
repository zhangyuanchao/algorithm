package com.greece.prometheus.linkedlist;

public class DoubleLinkedList {
	
	public class Node {
		public Integer data;// ������
		public Node prev; // ǰ��ָ��
		public Node next; // ����ָ��
		
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
		Node current = head.next; // ָ���һ���ڵ�
		Node next = current.next; // ָ��ڶ����ڵ�
		current.next = null; // ��һ���ڵ�������ڵ�Ͽ�
		Node prev = null;
		while (next != null) {
			prev = next.next;
			next.prev = null;
			current.prev = next;
			current = next; // ʹ��һ���ڵ��Ϊ��ǰ�ڵ�
			next = prev;
		}
		current.prev = head; // �����һ���ڵ��ǰ�ýڵ㸳ֵΪͷ�ڵ�ָ��
		head.next = current; // ��ͷ�ڵ�����ýڵ�����
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
