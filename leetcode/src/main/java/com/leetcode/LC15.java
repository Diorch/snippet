package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author diorch
 */
public class LC15 {

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // nums[i]若大于0，则nums[L]和nums[R]势必大于0，没必要继续执行
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1])
                        L++;
                    // 去重
                    while (L < R && nums[R] == nums[R - 1])
                        R--;
                }
                else if (sum < 0) {
                    L++;
                }
                else {
                    R--;
                }
            }
        }

        return ans;
    }
}
