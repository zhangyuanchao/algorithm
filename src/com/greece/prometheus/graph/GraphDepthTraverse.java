package com.greece.prometheus.graph;

import java.util.HashSet;
import java.util.Stack;

/**
 * 图的深度优先遍历
 * 1、利用栈实现
 * 2、从源节点开始把节点按照深度放入栈，然后弹出
 * 3、每弹出一个点，把该点下一个没有进过栈的邻居点放入栈
 * 4、直到栈变空
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
