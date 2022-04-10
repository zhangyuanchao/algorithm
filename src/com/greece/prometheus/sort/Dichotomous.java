package com.greece.prometheus.sort;

/**
 * ¶þ·Ö
 *
 */
public class Dichotomous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1, 6, 4, 4, 9, 8, 9, 7};
		// int result = findTarget1(arr, 6);
		int result = partialMin(arr);
		System.out.println(result);
	}
	
	public static int findTarget(int arr[], int target) {
		if (arr == null) {
			return -1;
		}
		int left = 0;
		int right = arr.length-1;
		while (left < right) {
			int mid = left + (right - left)/2;
			if (target == arr[mid]) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid;
			} else if (arr[mid] < target) {
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static int findTarget1(int arr[], int target) {
		if (arr == null) {
			return -1;
		}
		int L = 0, R = arr.length;
		while (L < R) {
			int mid = L + ((R - L)>>2);
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {
				L = mid + 1;
			} else {
				R = mid;
			}
		}
		return -1;
	}
	
	public static int partialMin(int arr[]) {
		if (arr == null || arr.length < 2) {
			return -1;
		}
		int len = arr.length;
		if (arr[1] < arr[0]) {
			return 1;
		}
		if (arr[len-2] < arr[len-1]) {
			return len - 2;
		}
		int L = 0, R = len;
		while (L < R) {
			int mid = L + ((R - L) >> 1);
			if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]) {
				return mid;
			} else if (arr[mid - 1] >= arr[mid] && arr[mid] >= arr[mid + 1]) {
				L = mid + 1;
			} else if (arr[mid + 1] >= arr[mid] && arr[mid] >= arr[mid - 1]) {
				R = mid;
			} else {
				
			}
		}
		return -1;
	}

}
