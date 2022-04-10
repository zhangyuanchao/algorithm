package com.greece.prometheus.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一系列字符串拼接，使得拼接后的字符串有最小的字典序
 *
 */
public class StringSplice {
	
	public static class SpliceComparator implements Comparator<String> {

		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);
		}
	}
	
	public static String splice(String[] strs) {
		Arrays.sort(strs, new SpliceComparator());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strs = {"b", "ba"};
		String res = splice(strs);
		System.out.println(res);
	}

}
