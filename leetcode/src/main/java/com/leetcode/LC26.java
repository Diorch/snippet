package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author diorch
 */
public class LC26 {

    public static void main(String[] args) {
        // System.out.println(gcd(100, 99));
        String s = "abcd";
        final LinkedList<Object> ll = new LinkedList<>();
        final Object[] objects = ll.toArray(new Object[2]);
        System.out.println(Arrays.toString(objects));
        // System.out.println(s.substring(1, 2));

        int len = s.length();
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                System.out.println(s.substring(l, r + 1));
            }
        }
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
            else {
                nums[j] = nums[i];
            }
        }
        Character s = 's';

        return j;

    }

    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
