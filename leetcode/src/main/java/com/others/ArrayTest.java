package com.others;

import java.util.Arrays;

/**
 * @author diorch
 */
public class ArrayTest {

    public static void main(String[] args) {

        //TODO auto generating..
        int[][] nums = new int[6][9];
        int k =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j =0; j< nums[0].length; j++) {
                nums[i][j] = k++;
            }
        }

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }
}
