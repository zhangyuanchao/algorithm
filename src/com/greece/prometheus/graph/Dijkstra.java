package com.greece.prometheus.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * ����Ȩֵû�и����ı�
 */
public class Dijkstra {
	
	public static HashMap<Node, Integer> dijkstra(Node head) {
		// ��head���������е����С����
		// key: ��head��������key
		// value: ��head��������key����С����
		// ����ڱ��У�û��T�ļ�¼�������Ǵ�head������T�����ľ���Ϊ������
		HashMap<Node, Integer> distanceMap = new HashMap<>();
		distanceMap.put(head, 0);
		// �Ѿ��������Ľڵ㣬����selectedNodes�У��Ժ���Ҳ����
		HashSet<Node> selectedNodes = new HashSet<>();
		Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		while (minNode != null) {
			int distance = distanceMap.get(minNode);
			for (Edge edge : minNode.edges) {
				Node toNode = edge.to;
				if (!distanceMap.containsKey(toNode)) {
					distanceMap.put(toNode, distance + edge.weight);
				}
				distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
			}
			selectedNodes.add(minNode);
			minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
		}
		return distanceMap;
	}
	
	public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
		Node minNode = null;
		int minDistance = Integer.MAX_VALUE;
		for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
			Node node = entry.getKey();
			int distance = entry.getValue();
			if (!touchedNodes.contains(node) && distance < minDistance) {
				minNode = node;
				minDistance = distance;
			}
		}
		return minNode;
	}
}
