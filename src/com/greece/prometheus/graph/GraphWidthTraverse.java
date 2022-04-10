package com.greece.prometheus.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ͼ�Ŀ�����ȱ���
 * 1�����ö���ʵ��
 * 2����Դ�ڵ㿪ʼ���ΰ��տ�Ƚ����У�Ȼ�󵯳�
 * 3��ÿ����һ���㣬�Ѹõ�����û�н������е��ھӵ�������
 * 4��ֱ�����б��
 *
 */
public class GraphWidthTraverse {
	
	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		HashSet<Node> set = new HashSet<>();
		queue.add(node);
		set.add(node);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value + " ");
			for (Node next : cur.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					queue.add(next);
				}
			}
		}
	}

}
