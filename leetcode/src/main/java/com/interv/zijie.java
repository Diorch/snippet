package com.interv;

/**
 * 判定顺子
 */
public class zijie {
    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");

    }

    public boolean solution(int[] nums) {
        if (nums.length != 7) {
            return false;
        }
        // sort nums

        for (int i = 0; i < nums.length; i++) {
            nums[i] = realVal(nums[i]);
        }

        // boolean result = false;
        int length = 1;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i + 1] - nums[i] == 1)) {
                length++;
                max = max > length ? max : length;
            } else if (nums[i + 1] == nums[i]) {
                continue;
            } else {
                length = 1;
            }
        }
        return max > 4;
    }

    public static int realVal(int x) {
        return x % 13;
    }
}