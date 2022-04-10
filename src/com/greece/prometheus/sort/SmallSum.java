package com.greece.prometheus.sort;

public class SmallSum {

	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5};
		int sum = smallSum(arr);
		System.out.println(sum);
	}
	
	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}
	
	public static int process(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		int mid = L + ((R - L) >> 1);
		return process(arr, L, mid) 
				+ process(arr, mid + 1, R)
				+ merge(arr, L, mid, R);
	}
	
	public static int merge1(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L, p2 = M+1;
		int sum = 0;
		while (p1 <= M && p2 <= R) {
			sum += arr[p1] < arr[p2] ? (R - p2 + 1)*arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return sum;
	}
	
	public static int merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		int p1 = L, p2 = M + 1;
		int sum = 0;
		int i = 0;
		while (p1 <= M && p2 <= R) {
			sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		return sum;
	}

}
