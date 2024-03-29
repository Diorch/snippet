package com.old;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。
 * 
 * 
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 */
public class Solution1109 {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        while (index2 >= 0) {
            if (index1 < 0) {
                for (int i = 0; i < index2 + 1; i++) {
                    nums1[i] = nums2[i];
                }
                break;
            }

            if (nums1[index1] >= nums2[index2]) {
                nums1[index1 + index2 + 1] = nums1[index1];
                index1 -= 1;
            } else {
                nums1[index1 + index2 + 1] = nums2[index2];
                index2 -= 1;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        // TODO
        int[] result = Solution1109.merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
        System.out.println(Arrays.toString(result));
    }
}