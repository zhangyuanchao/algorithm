package com.greece.prometheus.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ���л��ͷ����л�������
 * @author zhangyuanchao
 *
 */
public class SerializationAndReconstructTree {
	
	public static class Node {
		public int value; // ������
		public Node left; // ��ָ����
		public Node right; // ��ָ����
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	public static Node reconByPreString(String preStr) {
		String[] values = preStr.split("_");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < values.length; i++) {
			queue.add(values[i]);
		}
		return reconPreOrder(queue);
	}
	
	public static Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
