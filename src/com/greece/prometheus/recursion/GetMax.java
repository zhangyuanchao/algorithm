package com.greece.prometheus.recursion;

public class GetMax {

	public static void main(String[] args) {
		int[] arr = {4, 7, 2, 0, 1, 3};
		int max = process(arr, 0, arr.length - 1);
		System.out.println(max);

	}
	
	public static int process(int[] arr, int L, int R) {
		if (L == R) {
			return arr[L];
		}
		int mid = L + ((R - L) >> 1);
		int leftMax = process(arr, L, mid);
		int rightMax = process(arr, mid + 1, R);
		return Math.max(leftMax, rightMax);
	}

}
