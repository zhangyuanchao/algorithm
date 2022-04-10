package com.greece.prometheus.bd;

public class SeperateByNum {

	/**
	 * 给定一个数组arr, 一个num, 要求将<=num的数放在数组左边, >num的数放在右边
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 5, 6, 7, 4, 3, 5, 8};
		seperateTow(arr, 5);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
	
	/**
	 * 给定一个数组arr, 一个num, 要求将<=num的数放在数组左边, >num的数放在右边
	 * 1、小于num的边界为lessBound，arr[i] <= num，arr[i]和lessBound+1位置数交换，lessBound++, i++;
	 * 2、如果arr[i] > num，i++
	 * @param arr
	 * @param target
	 */
	public static void seperateTow(int[] arr, int target) {
		int lessBound = -1;
		int curr = 0;
		for (int i = 0; i < arr.length; i++) {
			curr = i;
			if (arr[i] <= target) {
				swap(arr, ++lessBound, curr);
			}
		}
	}
	
	/**
	 *  给定一个数组arr, 一个num, 要求将<num的数放在数组左边,  == num的数放在中间，>num的数放在右边
	 * 1、小于num的边界为lessBound，arr[i] < num，arr[i]和lessBound+1位置数交换，lessBound++, i++;
	 * 2、如果arr[i] = num，i++
	 * 3、如果arr[i] > num, arr[i]和moreBound-1位置数交换，moreBound--，i不变
	 * @param arr
	 * @param target
	 */
	public static void seperateThree(int[] arr, int target) {
		
	}
	
	public static void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		}
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

}
