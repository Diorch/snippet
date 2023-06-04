package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author diorch
 */
public class LC448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        //Map<Integer, Object> existNum= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (idx >= nums.length) {
                continue;
            }
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }

        }
        for (int i = 1; i <= nums.length ; i++) {
            if (nums[i - 1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        //TODO auto generating..
        final List<Integer> disappearedNumbers = new LC448().findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
        System.out.println(disappearedNumbers);

    }
}
