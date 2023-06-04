package com.leetcode;

import java.time.Year;

/**
 * @author diorch
 */
public class LC461 {

    public int t1(int x, int y) {
        int xor = x^y;
        int ans = 0;
        while (xor > 0) {
            if ((xor&1) == 1) {
                ++ans;
            }
            xor >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {

        //TODO auto generating..
        System.out.println(new LC461().t1(1, 4));
        final int i = Integer.bitCount(1 ^ 4);
        System.out.println(i);

    }
}
