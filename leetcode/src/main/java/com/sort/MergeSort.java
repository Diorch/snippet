package com.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 归并排序
 *
 * @author yedc@zhongmakj.com Date: 2018/11/19 21:33
 */
public class MergeSort {

    static int i = 0;

    /**
     * main
     */
    public static void main(String[] args) {

        final int[] ints = IntStream.generate(() -> new Random().nextInt(1000000)).limit(6).toArray();
        // final int[] ints = new int[] {8, 7, 6, 5, 4, 3, 2, 1};
        final int[] ints1 = Arrays.copyOf(ints, ints.length);

        final long l = System.currentTimeMillis();
        sort(ints, 0, ints.length - 1, new int[ints.length]);
        final long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        System.out.println(ints[0] + "/" + ints[ints.length - 1]);

        final long l2 = System.currentTimeMillis();
        Arrays.sort(ints1);
        final long l3 = System.currentTimeMillis();

        System.out.println(l3 - l2);
        System.out.println(ints1[0] + "/" + ints1[ints1.length - 1]);
    }

    public static void sort(int[] arr, int low, int high, int[] temp) {

        System.out.println("low: " + low + "; high: " + high);
        if (low >= high) {
            return;
        }

        int mid = (low + high) >>> 1;
        sort(arr, low, mid, temp);
        sort(arr, mid + 1, high, temp);

        merge(arr, low, mid, high, temp);
    }

    // 将两个有序序列归并为一个有序序列(二路归并)
    private static void merge(int[] array, int start, int mid, int end, int[] temp) {

        // int[] temp = new int[end + 1]; // 定义一个临时数组，用来存储排序后的结果
        int low = start; // 临时数组的索引
        int left = start;

        int center = mid + 1;
        // 取出最小值放入临时数组中
        while (start <= mid && center <= end) {
            temp[low++] = array[start] > array[center] ? array[center++] : array[start++];
        }

        // 若还有段序列不为空，则将其加入临时数组末尾

        while (start <= mid) {
            temp[low++] = array[start++];
        }
        while (center <= end) {
            temp[low++] = array[center++];
        }

        // 将临时数组中的值copy到原数组中
        System.arraycopy(temp, left, array, left, end + 1 - left);

        // System.out.println(Arrays.toString(array));

    }

    // public static List<Integer> sort(List<Integer> list, int low, int high) {
    //
    // int mid = (low + high) / 2;
    // if (low < high) {
    // sort(list, low, mid);
    // sort(list, mid + 1, high);
    //
    // merge(list, low, mid, high);
    // }
    // return list;
    // }
    //
    // public static void merge(List<Integer> list, int low, int mid, int high) {
    //
    // List<Integer> temp = new ArrayList<>(high - low + 1);
    //
    // int i = low;
    // int j = mid + 1;
    // int k = 0;
    //
    // while (i < mid && j < high) {
    // if (list.get(i) < list.get(j)) {
    // temp.set(k++, list.get(i++));
    // }
    // else {
    // temp.set(k++, list.get(j++));
    // }
    // }
    //
    // while (i < mid) {
    // temp.set(k++, list.get(i++));
    // }
    //
    // while (j <= high) {
    // temp.set(k++, list.get(j++));
    // }
    //
    // for (int x : temp) {
    // list.set(x + low, temp.get(x));
    // }
    // }
}
