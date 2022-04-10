package com.greece.prometheus.sort;

public class ShellSort {

	public static void main(String[] args) {
		int arr[] = {2, 5, 7, 1, 0, 4, 9, 3, 6, 8};
		shellSort1(arr);
		for (int e : arr) {
			System.out.println(e);
		}

	}
	
	public static int[] shellSort(int arr[]) {
		if (arr == null || arr.length < 2) {
			return arr;
		}
		int len = arr.length;
        int temp, gap = len / 2;
		while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
	}
	
	
	public static void shellSort1(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int len = arr.length, gap = len/2, current, preIndex;
		while (gap > 0) {
			for (int i = gap; i < len; i++) {
				current = arr[i];
				preIndex = i - gap;
				while (preIndex >= 0 && arr[preIndex] > current) {
					arr[preIndex + gap] = arr[preIndex];
					preIndex -= gap;
				}
				arr[preIndex + gap] = current;
			}
			gap /= 2;
		}
	}

}
