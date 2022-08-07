package com.sort;

/**
 * @author diorch
 */
public class QuickSort {

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // 从左向右遍历，找到比v大的
            while (Utils.less(a[++i], v)){
                if (i == hi) {
                    break;
                }
            }

            // 从右向左便利，找到比v小的
            while (Utils.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }


            if (i >= j) {
                break;
            }
            // 如果 i 还在 j 的左边，交换
            Utils.exch(a, i, j);
        }
        return j;
    }
}
