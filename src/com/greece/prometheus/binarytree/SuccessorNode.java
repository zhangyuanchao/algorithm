package com.greece.prometheus.binarytree;

/**
 * 后继节点
 * 中序遍历中，一个节点的后一个节点
 * 			A
 * 		  /   \
 * 		 B	   C
 * 	    / \   / \
 * 	   D   E F   G
 * 中序遍历: D->B->E->A->F->C-G
 * D的后继节点是B
 * B的后继节点是E
 * ...
 * @author zhangyuanchao
 *
 */
public class SuccessorNode {
	
	public static class Node {
		public int value; // 数据域
		public Node left; // 左指针域
		public Node right; // 右指针域
		public Node parent; // 父节点
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	/**
	 * 对于节点x，x的后继节点?
	 * 1、x有右子树，则x的后继节点是右子树的最左节点
	 * 2、x没有右树，
	 * @param node
	 * @return
	 */
	/**
	 * 	该结构比普通二叉树多了一个指向父节点的指针parent，结论就是:
		1、如果该节点有右子树，则该节点的后继节点为该节点的右子树上的最左节点。
		2、若该节点没有右子树，则向上找父节点，判断若该节点为父节点的左子树，则该父节点就是后继节点，
		若该节点为父节点的右孩子，则继续向上遍历，直到某个节点为其父节点的左孩子，则后继为该父节点，
		若未找到，说明该节点不存在父节点。
	 */
	public static Node getSuccessorNode1(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			// 有右子树，后继节点就是右子树的最左节点
			return getLeftMost(node.right);
		} else {
			// 无右子树
			Node parent = node.parent;
			while (parent != null && parent.left != node) { // 当前节点是其父节点的右孩子
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	/**
	 * 对于一个节点x
	 * 如果x有右子树，x的后继节点是右子树的最左节点
	 * 如果x没有右子树:
	 * 如果x是其父节点的左子树，x的后继节点是其父节点
	 * @param node
	 * @return
	 */
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			// 如果有右子树，后继节点就是右子树的最左节点
			return getLeftMost(node.right);
		} else {
			// 没有右子树，向上查找父节点，
			// 若该节点是父节点的左子树，则父节点是后继节点
			// 若该节点是父节点的右子树，则继续向上查找，直到某个节点是其父节点的左子树，父节点为后继节点
			// 若未找到，则说明该节点不存在父节点
			Node parent = node.parent;
			while (parent != null && parent.left != node) { 
				// 当前节点是父节点的右孩子，向上查找
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
