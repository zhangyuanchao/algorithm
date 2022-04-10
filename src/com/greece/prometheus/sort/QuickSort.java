package com.greece.prometheus.sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// arr[l...r]�ź���
	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0] - 1); // <��
			quickSort(arr, p[1] + 1, R); // >��
		}
	}
	
	// ����һ������arr[l...r]�ĺ���
	// Ĭ����arr[r]�����֣�arr[r] -> p  <p	==p		>p
	// ���ص�������(��߽磬�б߽�)�����Է���һ������Ϊ2������res��res[0], res[1]
	public static int[] partition(int[] arr, int L, int R) {
		int less = L - 1;  // <�����ұ߽�
		int more = R; // >������߽�
		while (L < more) { // L��ʾ��ǰ����λ�ã�arr[R] -> ����ֵ
			if (arr[L] < arr[R]) { //��ǰ�� < ����ֵ
				swap(arr, ++less, L++);
			} else if (arr[L] > arr[R]) { // ��ǰ�� > ����ֵ
				swap(arr, --more, L);
			} else {
				L++;
			}
		}
		swap(arr, more, R);
		return new int[] {less + 1, more};
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
