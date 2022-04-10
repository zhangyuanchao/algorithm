package com.greece.prometheus.sort;

public class EvenTimesOddTimes {
	
	public static void printOddTimesNum1(int arr[]) {
		int eor = 0;
		for (int cur : arr) {
			eor = eor ^ cur;
		}
		System.out.println(eor);
	}
	
	public static void printOddTimesNum2(int arr[]) {
		int eor = 0;
		for (int cur : arr) {
			eor = eor ^ cur;
		}
		// eor = a ^ b
		// eor != 0 eor��Ȼ��һ��λ����1
		int rightOne = eor & (~eor + 1); // ��ȡ�����ҵ�1
		int onlyOne = 0;
		for (int cur : arr) {
			if ((cur & rightOne) == 0) {
				onlyOne ^= cur;
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
