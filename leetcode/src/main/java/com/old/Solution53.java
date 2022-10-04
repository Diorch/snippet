package com.old;

public class Solution53 {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(solution(nums));
        System.out.println(solution2(nums));
    }

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = Math.max(nums[i], nums[i] + ans[i - 1]);
            if (max < ans[i]) {
                max = ans[i];
            }
        }
        return max;

    }

    static int solution2(int[] nums) {
        int result = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum > 0) {
                sum += n;
            } else {
                sum = n;
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}