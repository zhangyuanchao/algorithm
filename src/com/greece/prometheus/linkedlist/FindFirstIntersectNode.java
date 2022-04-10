package com.greece.prometheus.linkedlist;

public class FindFirstIntersectNode {
	
	public static class Node {
		public int data; // 数据域
		public Node next; // 指针域
		public Node(int data) {
			this.data = data;
		}
	}
	
	// 找到单链表第一个入环节点, 如果无环，返回null
	public Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node p1 = head.next; // slow
		Node p2 = head.next.next; // fast
		// 如果是有环链表, p1 p2一定在环上相遇
		while (p1 != p2) {
			if (p2.next == null || p2.next.next == null) {
				// 无环链表
				return null;
			}
			p1 = p1.next;
			p2 = p2.next.next;
		}
		p2 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	// 两个链表都是无环链表
	public Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null || head1.next == null || head2.next == null) {
			return null;
		}
		Node cur1 = head1; // 链表1尾节点
		Node cur2 = head2; // 链表2尾节点
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			// 两个链表不相交
			return null;
		}
		cur1 = n > 0 ? head1 : head2; // cur1指向长链表的头节点
		cur2 = cur1 == head1 ? head2 : head1; // cur2指向短链表头节点
		n = Math.abs(n); // n就是长短链表长度的差值
		// 长链表先走差值步
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		// 长短链表同时走, 一定在第一个相交节点处相遇
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	/**
	 *  两个链表都是有环链表，有三种位置关系
	 * 1、两个链表不相交
	 * 2、只有一个入环节点
	 * 3、有两个入环节点
	 * @param head1 第一个链表头节点
	 * @param loop1 第一个链表入环节点
	 * @param head2 第二个链表头节点
	 * @param loop2 第二个链表入环节点
	 * @return
	 */
	public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if (loop1 == loop2) {
			// 只有一个入环节点, 可以看作loop1(loop2)为尾节点的无环链表相交
			Node cur1 = head1;
			Node cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			Node cur = loop1.next;
			while (cur != loop1) {
				// 有两个入环节点, loop1在环上走，再次回到原点时一定会遇上loop2
				if (cur == loop2) {
					return loop1;
				}
			}
			// 无相交节点
			return null;
		}
		
	}
	
	/**
	 * 返回两个单链表第一个相交节点
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node getFirstIntersect(Node head1, Node head2) {
		Node loop1 = getLoopNode(head1); // 链表1的入环节点，无环则为null
		Node loop2 = getLoopNode(head2); // 链表2的入环节点
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		// 一个无环链表和一个有环链表一定不相交
		return null;
	}
}
