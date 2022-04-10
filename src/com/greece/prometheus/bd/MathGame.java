package com.greece.prometheus.bd;

import java.util.Random;

/**
 * 将一个整数质数分解
 *
 */
public class MathGame {

	public static void main(String[] args) {
		Thread t = new Thread(new PrimeNumberDecomposition());
		t.start();
	}

	public static class PrimeNumberDecomposition implements Runnable {

		@Override
		public void run() {
			while (true) {
				// TODO Auto-generated method stub
				Random rand = new Random();
				int inputNum = rand.nextInt();
				if (inputNum < 0) {
					continue;
				}
				factor(inputNum);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void factor(int num) {
		System.out.print("分解的结果为：");
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				System.out.print(i + "*");
				num /= i;
				i--;
			}
		}
		System.out.println(num);
	}

}
