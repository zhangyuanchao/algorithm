package com.greece.prometheus.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSort1(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0~0有序
		// 0~i想有序
		for (int i = 1; i < arr.length; i++) { // 0~i做到有序
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j+1);
			}
		}
	}
	
	public static void insertionSort2(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i=1; i < arr.length; i++) {
			for (int j = i-1; j>=0 && arr[j] > arr[j+1]; j--) {
				swap(arr, j, j+1);
			}
		}
	}
	
	public static void swap1(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void insertionSort(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int current;
		for (int i = 0; i < arr.length - 1; i++) {
			current = arr[i+1];
			int preIndex = i;
			while (preIndex >= 0 && arr[preIndex] > current) {
				// preIndex位置元素右移
				arr[preIndex+1] = arr[preIndex];
				preIndex--;
			} 
			arr[preIndex+1] = current;
		}
	}
	
	public static void swap(int arr[], int i, int j) {
		if (i == j) {
			return;
		}
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// Math.random() -> [0, 1)所有的小数
		int[] arr = new int[(int)((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			insertionSort(arr1);
			comparator(arr2);
			if (isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		insertionSort(arr);
		printArray(arr);
	}
	
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] copiedArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copiedArr[i] = arr[i];
		}
		return copiedArr;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null || arr2 == null) || arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		for (int e : arr) {
			System.out.println(e);
		}
	} 

}
