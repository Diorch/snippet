package com.interv;
//Programming Test

//Question 1
//Title
//和为K的子数组个数

//Question description
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数​
//输入：nums = [1,2,3], k = 3 ​
//输出：2 ​
//输入：nums = [1,2,0,3,4], k = 3 ​
//输出：?​

public class zijie2 {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
        int[] nums = new int[] { 1, 2, 0, 3, 4 };
        int k = 3;
        System.out.println(new zijie2().t1(nums, k));
    }

    public int t1(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (sum == k) {
                    cnt++;
                } else if (sum + nums[j] == k) {
                    cnt++;
                } else {
                    sum += nums[j];
                }
            }
            if (sum == k) {
                cnt++;
            }
        }
        return cnt;
    }
}
