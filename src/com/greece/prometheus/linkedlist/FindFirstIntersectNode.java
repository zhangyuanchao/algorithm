package com.greece.prometheus.linkedlist;

public class FindFirstIntersectNode {
	
	public static class Node {
		public int data; // ������
		public Node next; // ָ����
		public Node(int data) {
			this.data = data;
		}
	}
	
	// �ҵ��������һ���뻷�ڵ�, ����޻�������null
	public Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node p1 = head.next; // slow
		Node p2 = head.next.next; // fast
		// ������л�����, p1 p2һ���ڻ�������
		while (p1 != p2) {
			if (p2.next == null || p2.next.next == null) {
				// �޻�����
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
	
	// �����������޻�����
	public Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null || head1.next == null || head2.next == null) {
			return null;
		}
		Node cur1 = head1; // ����1β�ڵ�
		Node cur2 = head2; // ����2β�ڵ�
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
			// ���������ཻ
			return null;
		}
		cur1 = n > 0 ? head1 : head2; // cur1ָ�������ͷ�ڵ�
		cur2 = cur1 == head1 ? head2 : head1; // cur2ָ�������ͷ�ڵ�
		n = Math.abs(n); // n���ǳ��������ȵĲ�ֵ
		// ���������߲�ֵ��
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		// ��������ͬʱ��, һ���ڵ�һ���ཻ�ڵ㴦����
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	/**
	 *  �����������л�����������λ�ù�ϵ
	 * 1�����������ཻ
	 * 2��ֻ��һ���뻷�ڵ�
	 * 3���������뻷�ڵ�
	 * @param head1 ��һ������ͷ�ڵ�
	 * @param loop1 ��һ�������뻷�ڵ�
	 * @param head2 �ڶ�������ͷ�ڵ�
	 * @param loop2 �ڶ��������뻷�ڵ�
	 * @return
	 */
	public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if (loop1 == loop2) {
			// ֻ��һ���뻷�ڵ�, ���Կ���loop1(loop2)Ϊβ�ڵ���޻������ཻ
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
				// �������뻷�ڵ�, loop1�ڻ����ߣ��ٴλص�ԭ��ʱһ��������loop2
				if (cur == loop2) {
					return loop1;
				}
			}
			// ���ཻ�ڵ�
			return null;
		}
		
	}
	
	/**
	 * ���������������һ���ཻ�ڵ�
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node getFirstIntersect(Node head1, Node head2) {
		Node loop1 = getLoopNode(head1); // ����1���뻷�ڵ㣬�޻���Ϊnull
		Node loop2 = getLoopNode(head2); // ����2���뻷�ڵ�
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		// һ���޻������һ���л�����һ�����ཻ
		return null;
	}
}
