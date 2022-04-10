package com.greece.prometheus.bd;

public class SeperateByNum {

	/**
	 * ����һ������arr, һ��num, Ҫ��<=num���������������, >num���������ұ�
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
	 * ����һ������arr, һ��num, Ҫ��<=num���������������, >num���������ұ�
	 * 1��С��num�ı߽�ΪlessBound��arr[i] <= num��arr[i]��lessBound+1λ����������lessBound++, i++;
	 * 2�����arr[i] > num��i++
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
	 *  ����һ������arr, һ��num, Ҫ��<num���������������,  == num���������м䣬>num���������ұ�
	 * 1��С��num�ı߽�ΪlessBound��arr[i] < num��arr[i]��lessBound+1λ����������lessBound++, i++;
	 * 2�����arr[i] = num��i++
	 * 3�����arr[i] > num, arr[i]��moreBound-1λ����������moreBound--��i����
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
