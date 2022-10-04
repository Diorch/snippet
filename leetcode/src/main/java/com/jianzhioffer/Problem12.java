package com.jianzhioffer;

import java.util.Arrays;

/**
 * 回溯法
 * 
 * 矩阵中的路径
 */
public class Problem12 {

    /**
     * 
     * @param matrix 给定的二维数组
     * @param word   目标字符串
     * @return
     */
    public boolean hasPath(char[][] matrix, String word) {
        char[] str = word.toCharArray();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (hasPathCore(matrix, str, row, col, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param matrix     给定的二维数组
     * @param str        目标字符串
     * @param row        目标行号
     * @param col        目标列号
     * @param pathLength 目标字符串已匹配的字符长度
     * @return
     */
    private boolean hasPathCore(char[][] matrix, char[] str, int row, int col, int pathLength) {
        // 终结递归条件： 目标行号、目标列号越界时；指定座标（行号+列号）的字符非预期字符
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || matrix[row][col] != str[pathLength]) {
            return false;
        }

        // 走到这里时，意味着指定座标的字符为预期字符。此时，若已检索的路径长度与目标字符长度相等，说明完成了
        if (pathLength == str.length - 1) {
            return true;
        }

        // 走到这里时，意味着目标字符尚未完全找到，继续找下个匹配的字符的位置。且将定位到的座标的字符标记为\0，
        // matrix[row][col] = '\0';
        boolean hasPath = hasPathCore(matrix, str, row + 1, col, pathLength + 1)
                || hasPathCore(matrix, str, row - 1, col, pathLength + 1)
                || hasPathCore(matrix, str, row, col + 1, pathLength + 1)
                || hasPathCore(matrix, str, row, col - 1, pathLength + 1);

        // matrix[row][col] = str[pathLength];
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
        String word = "bfce";
        boolean hasPath = new Problem12().hasPath(matrix, word);
        System.out.println("hasPath: " + hasPath);
        // for (char[] s : matrix) {
        // System.out.println(Arrays.toString(s));
        // }
    }
}
