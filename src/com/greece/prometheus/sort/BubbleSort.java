package com.greece.prometheus.sort;

public class BubbleSort {

	public static void main(String[] args) {
//		int arr[] = {2, 7, 5, 9, 4, 3, 8, 1, 3, 0};
//		bubbleSort(arr);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println(0 ^ 1);
	}
	
	public static void bubbleSort(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i ++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
	
	// 交换arr的i和j位置的值
	public static void swap(int arr[], int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

}
