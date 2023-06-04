package com.interv;

/**
 * 
 * 删除有序数组中的重复项
 * 
 */
public class xhs2 {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");

    }

    public int solution(Integer[] nums) {
        int cur = 1;
        int i = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
            } else {
                int t = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = t;
            }
        }
        return cur;
    }
}