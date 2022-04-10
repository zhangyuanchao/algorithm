package com.greece.prometheus.linkedlist;

public class SingleLinkedList {
	
	public class Node {
		private Integer data; // 节点数据
		private Node next; // 节点指针
		
		public Node() {
			
		}
		public Node(Integer data) {
			this.data = data;
		}
		public Integer getData() {
			return data;
		}
		public void setData(Integer data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	Node reverseList(Node head) {
		// 如果链表为空或者只有一个元素, 直接返回
		if(head == null) return null;
        Node pre = null;
        Node next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
	}
	
	Node createList(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		Node head = new Node();
		Node curr = head;
		for (int i = 0; i < arr.length; i++) {
			curr.setNext(new Node(arr[i]));
			curr = curr.getNext();
		}
		return head.getNext();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 6, 7,3, 0, 1};
		SingleLinkedList me = new SingleLinkedList();
		Node head = me.createList(arr);
		while (head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

}
