package com.greece.prometheus.bd;

/**
 * 给定一个整数数组，判断是否是回文数组
 * @author zhangyuanchao
 *
 */
public class Palindrome {

    public static void main(String[] args) {
        int raw[] = {1, 2, 4, 6, 9, 3, 3, 9, 6, 5, 2, 1};
        // int raw[] = {1};
        int len = raw.length;
        boolean ispalindromed = true;
        for (int i = 0; i < len; i++) {
            if (i >= len/2 + 1) {
                raw[len-1 - i] = raw[i] - raw[len-1 - i];
                if (raw[len-1 - i] != 0) {
                    ispalindromed = false;
                    break;
                }
            }
        }
        if (ispalindromed) {
            System.out.println("是回文数组");
        } else {
            System.out.println("不是回文数组");
        }
    }
}
