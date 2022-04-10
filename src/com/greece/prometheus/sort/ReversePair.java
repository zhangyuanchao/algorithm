package com.greece.prometheus.sort;

public class ReversePair {

	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 5, 0, 1};
		int count = reversePair(arr);
		System.out.println(count);
	}
	
	public static int reversePair(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}
	
	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int m = l + (( r - l) >> 1);
		return process(arr, l, m) + process(arr, m + 1, r) + merge(arr, l, m, r);
	}
	
	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int p1 = l, p2 = m + 1;
		int count = 0;
		int i = 0;
		while (p1 <= m && p2 <= r) {
			count += arr[p1] > arr[p2] ? (m - p1 + 1) : 0;
			help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return count;
	}

}
