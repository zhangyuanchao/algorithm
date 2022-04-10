package com.greece.prometheus.binarytree;

/**
 * ����������
 * ����һ���ڵ�x
 * 1��������������������
 * 2��������������������
 * 3��������max < x
 * 4�������� min > x
 * @author zhangyuanchao
 *
 */
public class SearchBinaryTree {
	
	public static class Node {
		public int value; // ������
		public Node left; // ��ָ����
		public Node right; // ��ָ����
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static class ResultData {
		public boolean isbst;
		public int min;
		public int max;
		
		public ResultData(boolean isbst, int min, int max) {
			this.isbst = isbst;
			this.min = min;
			this.max = max;
		}
	}
	
	public static ResultData isBST(Node head) {
		return process(head);
	}
	
	public static ResultData process(Node x) {
		if (x == null) {
			return null;
		}
		ResultData leftData = process(x.left);
		ResultData rightData = process(x.right);
		int min = x.value;
		int max = x.value;
		if (leftData != null) {
			min = Math.min(min, leftData.min);
			max = Math.max(max, leftData.max);
		}
		if (rightData != null) {
			min = Math.min(min, rightData.min);
			max = Math.max(max, rightData.max);
		}
		boolean isbst = true;
		if (leftData != null && (!leftData.isbst || leftData.max >= x.value)) {
			isbst = false;
		}
		if (rightData != null && (!rightData.isbst || leftData.min <= x.value)) {
			isbst = false;
		}
		return new ResultData(isbst, min, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
