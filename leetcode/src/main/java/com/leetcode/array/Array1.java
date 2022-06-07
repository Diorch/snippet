package com.leetcode.array;

import com.leetcode.dto.Node;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dechuye
 */
@Slf4j
public class Array1 {

    /**
     * 二分法
     *
     * @return 目标值索引，无则返回-1
     */
    public static int binarySearch(Integer[] ints, Integer target) {
        if (ints == null || ints.length == 0) {
            return -1;
        }

        int left = 0;
        int right = ints.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ints[mid] > target) {
                right = mid - 1;
            }
            else if (ints[mid] < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 反转链表
     */
    public static Node revLink01(Node link) {
        if (link == null || link.next == null) {
            return link;
        }

        Node newLink = null;
        Node temp;
        while (link != null) {
            temp = link.next;
            link.next = newLink;
            newLink = link;
            link = temp;
        }
        return newLink;
    }

    /**
     * 递归反转链表
     */
    public static Node revLink02(Node link) {
        if (link == null || link.next == null) {
            return link;
        }

        final Node last = revLink02(link.next);
        link.next.next = link;
        link.next = null;
        return last;
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 循环次数
        int loop = n / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 定义中间位置
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j < startY + n - offset; j++) {
                res[i][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
