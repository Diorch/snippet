package com.leetcode;

public class LC004 {
    public static void main(String[] args) {
        // TODO
        System.out.println("hi");
    }

    /**
     * 归并法，时间复杂度O(m+n)
     *
     */
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {

        int a[] = new int[nums1.length + nums2.length];
        int lIdx = 0;
        int rIdx = 0;
        int idx = 0;
        // 将nums1和nums2有序填充至a
        while (lIdx < nums1.length && rIdx < nums2.length) {
            if (nums1[lIdx] < nums2[rIdx]) {
                a[idx++] = nums1[lIdx++];
            } else {
                a[idx++] = nums2[rIdx++];
            }
        }
        // 将两个数组中未触底的剩余元素全部移动到a
        while (lIdx < nums1.length) {
            a[idx++] = nums1[lIdx++];
        }
        while (rIdx < nums2.length) {
            a[idx++] = nums2[rIdx++];
        }
        // 长度为偶数、奇数分别有不同的中位数计算公式
        if (a.length % 2 == 0) {
            return (double) (a[a.length / 2 - 1] + a[a.length / 2]) / 2;
        } else {
            return a[a.length / 2];
        }
    }

    /**
     * 二分法
     */
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {

    }

}
