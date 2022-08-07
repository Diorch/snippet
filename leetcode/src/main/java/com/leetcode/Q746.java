package com.leetcode;

/**
 * 最小花费爬楼梯
 *
 * @author diorch
 */
public class Q746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = (dp[i - 1] > dp[i - 2] ? dp[i - 2] : dp[i - 1]) + cost[i];
        }

        return dp[cost.length - 2] > dp[cost.length - 1] ? dp[cost.length - 1] : dp[cost.length - 2];
    }
}
