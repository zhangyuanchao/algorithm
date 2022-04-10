package com.greece.prometheus.sort;

/**
 * ��������
 * @author zhangyuanchao
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
	}
	
	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			// ȡ��arr��������
			max = Math.max(max, arr[i]);
		}
		int res = 0;
		while (max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}
	
	// arr[begin..end]����
	public static void radixSort(int[] arr, int L, int R, int digit) {
		final int radix = 10;
		int i = 0, j = 0;
		// �ж��ٸ���׼�����ٸ������ռ�
		int[] bucket = new int[R - L +1];
		for (int d = 1; d < digit; d++) { // �ж���λ�ͽ�������
			// 10���ռ�
			// count[0] ��ǰλ(dλ) ��0�������ж��ٸ�
			// count[1] ��ǰλ(dλ) ��0��1�������ж��ٸ�
			// count[2] ��ǰλ(dλ) ��0��1��2�������ж��ٸ�
			// count[i]��ǰλ(dλ) ��0~i�������ж��ٸ�
			int[] count = new int[radix]; // count[0..9]
			for (i = L; i < R; i++) {
				// j = gitDigit(arr[i], d);
				count[j]++;
			}
			for (i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];
			}
			for (i = R; i >= L; i--) {
				// j = getDigit(arr[i], d);
				bucket[count[j] - 1] = arr[i];
				count[j]--;
			}
		}
	}

}
