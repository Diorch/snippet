package com.leetcode;

import com.dto.TreeNode;

/**
 * @author diorch
 */
public class LC543 {

    int ans = 0;
    public int t1(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        ans = Math.max(ans, lDepth + rDepth);
        // 当前节点的高度为：max(lDepth, rDepth) + 1
        return Math.max(lDepth, rDepth)+ 1;
    }

}
