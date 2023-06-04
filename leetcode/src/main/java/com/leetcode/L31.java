package com.leetcode;

/**
 * 下一个排列
 */
public class L31 {

    public void t1(int[] nums) {
        // 找出逆序idx
        int idx = findRevIdx(nums);
        // swp nums[idx-1]与idx右边中大于nums[idx-1]
        if (idx != 0) {
            swap(nums, idx);
        }

        // rev
        rev(nums, idx);
    }

    public int findRevIdx(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }

        return 0;
    }

    public void swap(int[] nums, int idx) {
        for (int i = nums.length; i > idx; i--) {
            if (nums[i] > nums[idx - 1]) {
                int tmp = nums[i];
                nums[i] = nums[idx - 1];
                nums[idx - 1] = tmp;
                break;
            }
        }
    }

    public void rev(int[] nums, int idx) {
        for (int l = idx, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
