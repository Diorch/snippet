package com.old;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution001 {

    // public static int[] twoSum(int[] nums, int target) {
    // Map<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < nums.length; i++) {
    // int complement = target - nums[i];
    // if (map.containsKey(complement)) {
    // return new int[] { map.get(complement), i };
    // }
    // map.put(nums[i], i);

    // }
    // throw new IllegalArgumentException("No two sum solution");

    // }

    // --------------------//
    // int size = 2048;
    // int[] map = new int[size];
    // int length = 2047;
    // int index;

    // public int[] twoSum(int[] nums, int target) {
    // for (int i = 0; i < nums.length; i++) {
    // index = nums[i] & length;

    // if (map[index] != 0) {
    // return new int[] { map[index] - 1, i };
    // } else {
    // map[(target - index) & length] = i + 1;
    // }
    // }
    // throw new IllegalArgumentException("No two sum solution");
    // }

    // --------------------//
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution001().twoSum(new int[] { 2, 7, 11, 15, 1, 34, 32, 22, 4, 12, 98 }, 110)));
    }
}