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
			head.next = null; // 从原链表断开
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
			eT = eT == null ? sT : eT; // 下一步，谁去连接大区域的头，谁就变成eT
		}
		// 上面的if，不管跑了没有，eT
		// all reconnect
		if (eT != null) { // 如果小于区域和等于区域，不是都没有
			eT.next = mH;
		}
		return sH != null ? sH : (eH != null ? eH : mH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
