package com.old;

public class Solution009 {

    public boolean isPalindrome(int x) {

        int[] list = new int[32];

        if (x < 0) {
            return false;
        } else if (x >= 0 && x < 10) {
            return true;
        } else {

            int i = 0;
            while (x > 0) {
                list[i++] = x % 10;
                x /= 10;
            }

            int j = 0;
            while (j < i) {
                if (list[j++] != list[--i]) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution009().isPalindrome(-121));
    }
}