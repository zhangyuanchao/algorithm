package com.greece.prometheus.linkedlist;

public class SmallerEqualBigger {
	
	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node listPartition(Node head, int pivot) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node mH = null; // big head
		Node mT = null; // big tail
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null; // ��ԭ����Ͽ�
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sH.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eH.next = head;
					eT = head;
				}
			} else {
				if (mH == null) {
					mH = head;
					mT = head;
				} else {
					mH.next = head;
					mT = head;
				}
			}
			head = next;
		}
		// small and equal reconnect
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT; // ��һ����˭ȥ���Ӵ������ͷ��˭�ͱ��eT
		}
		// �����if����������û�У�eT
		// all reconnect
		if (eT != null) { // ���С������͵������򣬲��Ƕ�û��
			eT.next = mH;
		}
		return sH != null ? sH : (eH != null ? eH : mH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
