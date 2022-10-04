package com.sort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 递归二分查找
 *
 * @author yedc@zhongmakj.com Date: 2018/11/19 19:59
 */
public class RecursionBinarySearch {
    /**
     * main
     */
    public static void main(String[] args) {

        final AtomicInteger atomicInteger = new AtomicInteger(1);
        final List<Integer> collect = Stream.generate(atomicInteger::getAndIncrement).limit(1024)
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println(binarySearch(collect, 512, 0, collect.size() - 1));

        final int i = Arrays.binarySearch(collect.toArray(), 512);

        System.out.println(i);
    }

    public static int binarySearch(List<Integer> arr, int key, int low, int high) {

        System.out.println("******");
        if (key < arr.get(low) || key > arr.get(high)) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (key < arr.get(mid)) {
            return binarySearch(arr, key, low, mid);
        } else if (key > arr.get(mid)) {
            return binarySearch(arr, key, mid, high);
        } else {
            return mid;
        }
    }
}
