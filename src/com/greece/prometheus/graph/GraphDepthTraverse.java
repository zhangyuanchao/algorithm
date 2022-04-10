package com.greece.prometheus.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * ͼ��������ȱ���
 * 1������ջʵ��
 * 2����Դ�ڵ㿪ʼ�ѽڵ㰴����ȷ���ջ��Ȼ�󵯳�
 * 3��ÿ����һ���㣬�Ѹõ���һ��û�н���ջ���ھӵ����ջ
 * 4��ֱ��ջ���
 *
 */
public class GraphDepthTraverse {
	
	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		HashSet<Node> set = new HashSet<>();
		stack.push(node);
		set.add(node);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.value);
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					stack.push(cur);
					stack.push(next);
					set.add(next);
					break;
				}
			}
		}
	}

}
