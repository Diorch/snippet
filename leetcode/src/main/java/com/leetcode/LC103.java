package com.leetcode;

import java.util.*;

/**
 * 二叉树锯齿形层次遍历
 *
 * @author diorch
 */
public class LC103 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int cnt = q.size();
            List<Integer> temp = new ArrayList<>();
            while (cnt-- != 0) {
                TreeNode node = q.peek();
                temp.add(node.val);
                q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (ans.size() % 2 == 1) {
                Collections.reverse(temp);
            }
            ans.add(temp);
        }
        return ans;
    }
}
