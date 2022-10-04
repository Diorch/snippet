package com.old;

public class Solution1108 {

    public boolean Find(int target, int[][] array) {
        // 特殊情况处理
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int h = array.length - 1;
        int w = array[0].length - 1;

        // 如果目标值小于最小值 或者 目标值大于最大值，那肯定不存在
        if (array[0][0] > target || array[h][w] < target) {
            return false;
        }
        return binarySearchIn2DArray(array, target, 0, h, 0, w);
    }

    public static boolean binarySearchIn2DArray(int[][] array, int target, int startX, int endX, int startY, int endY) {
        if (startX > endX || startY > endY) {
            return false;
        }
        // 首先，根据二分法找出中间行
        int x = (startX + endX) / 2;
        // 对该行进行二分查找
        int result = binarySearch(array[x], target, startY, endY);
        // 找到的值位于 x 行，result 列
        if (array[x][result] == target) {
            return true; // 如果找到则成功
        }
        // 对剩余的两部分分别进行递归查找
        return binarySearchIn2DArray(array, target, startX, x - 1, result + 1, endY)
                || binarySearchIn2DArray(array, target, x + 1, endX, startY, result);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        int i = (start + end) / 2;
        if (array[i] == target || start > end) {
            return i;
        } else if (array[i] > target) {
            return binarySearch(array, target, start, i - 1);
        } else {
            return binarySearch(array, target, i + 1, end);
        }
    }
}