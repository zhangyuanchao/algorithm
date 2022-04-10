package com.greece.prometheus.binarytree;

public class PaperFolding {
	
	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}
	
	// �ݹ���̣�������ĳһ���ڵ�
	// i�ǽڵ�Ĳ�����Nһ���Ĳ�����down==true ����down==false ͹
	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i+1, N, true); // ������������������ͷ�ڵ㶼��"��"
		System.out.println(down ? "��" : "͹");
		printProcess(i+1, N, false); // ������ͷ�ڵ㶼��͹
	}

	public static void main(String[] args) {
		int N = 4;
		printAllFolds(N);
	}

}
