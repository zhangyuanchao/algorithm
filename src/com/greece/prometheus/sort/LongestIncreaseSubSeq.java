package com.greece.prometheus.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreaseSubSeq {

	public static void main(String[] args) {
		List<Integer> raw = new ArrayList<>(Arrays.asList(new Integer[]{2, 3,5,7,6,4,8,9,1,3,5,9}));
		List<List<Integer>> subSeq = new ArrayList<>(); //保存增长子序列的index
		Integer curIndex = 0; // 当前值下标
		for (Integer i = 0; i < raw.size(); i++) {
			if (raw.get(curIndex) >= raw.get(i)) {
				// 新的子序列
				subSeq.add(new ArrayList<>());
			}
			curIndex = i;
			subSeq.get(subSeq.size() - 1).add(i);
		}
		for (List l : subSeq) {
			System.out.println(l.size());
		}
	}
}
