package com.leetcode;

/**
 * 斐波纳契数列
 *
 * @author diorch
 */
public class Q509 {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
