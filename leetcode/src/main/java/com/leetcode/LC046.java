package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 回溯
 */
public class LC046 {

    public List<List<Integer>> permute2(int[] nums) {
        // 初始化结果集
        List<List<Integer>> ans = new ArrayList<>();

        dfs(nums, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = temp.size(); i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, ans, temp);
            temp.remove(temp.size() - 1);

        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[nums.length];

        dfs(nums, used, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans) {
        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, used, temp, ans);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<Integer>> t3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs3(nums, used, new ArrayList<>(), ans);
        return ans;
    }

    public void dfs3(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> ans) {
        if (nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs3(nums, used, temp, ans);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
