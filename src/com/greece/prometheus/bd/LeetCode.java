package com.greece.prometheus.bd;

import java.util.HashMap;

public class LeetCode {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int label[] = new int[2];
        HashMap<Integer, Integer> numLocation = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numLocation.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numLocation.containsKey(target - nums[i]) && i != numLocation.get(target - nums[i])) {
                label[0] = i;
                label[1] = numLocation.get(target - nums[i]);
                break;
            }
        }
        return label;
    }

    private ListNode initNode(int[] a) {
        ListNode h = new ListNode();
        ListNode current = null;

        for (int i = 0; i < a.length; i++) {

        }
        return null;
    }

    private ListNode[] initListNode(int[] a1, int[] a2) {
        ListNode n1 = new ListNode();
        return null;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	return null;
    }
}
