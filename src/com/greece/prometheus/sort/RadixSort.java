package com.greece.prometheus.sort;

/**
 * 基数排序
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
			// 取出arr中最大的数
			max = Math.max(max, arr[i]);
		}
		int res = 0;
		while (max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}
	
	// arr[begin..end]排序
	public static void radixSort(int[] arr, int L, int R, int digit) {
		final int radix = 10;
		int i = 0, j = 0;
		// 有多少个数准备多少个辅助空间
		int[] bucket = new int[R - L +1];
		for (int d = 1; d < digit; d++) { // 有多少位就进出几次
			// 10个空间
			// count[0] 当前位(d位) 是0的数字有多少个
			// count[1] 当前位(d位) 是0和1的数字有多少个
			// count[2] 当前位(d位) 是0、1和2的数字有多少个
			// count[i]当前位(d位) 是0~i的数字有多少个
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
