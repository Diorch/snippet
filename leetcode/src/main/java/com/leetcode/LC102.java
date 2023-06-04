package com.leetcode;

import java.util.*;

import com.dto.TreeNode;

/**
 * 二叉树层序遍历
 *
 * @author diorch
 */
public class LC102 {

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
                final TreeNode node = q.peek();
                q.poll();
                temp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    /**
     * 2023.05.06 17:00
     */
    public static List<List<Integer>> t2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> chunk = new ArrayList<>();
            int cnt = q.size();
            while (cnt > 0) {
                cnt--;
                TreeNode n = q.poll();

                chunk.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            ans.add(chunk);
        }
        return ans;
    }
}
