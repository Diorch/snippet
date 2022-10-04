package com.old;

public class Solution014 {

    public static void main(String[] args) {

        // System.out.println('A' ^ 'A');
        System.out.println(new Solution014().longestCommonPrefix(new String[] { "flower", "", "flight" }));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int min = 0;
        String first = strs[0];
        char[] firstChars = first.toCharArray();
        for (int i = 1; i < strs.length; i++) {
            char[] tempChar = strs[i].toCharArray();
            int j = 0;
            for (; j < firstChars.length && j < tempChar.length && ((tempChar[j] ^ firstChars[j]) == 0); j++) {
            }

            min = i == 1 ? j : (min > j ? j : min);
        }

        return min == 0 ? "" : first.substring(0, min);
    }

    // 最优解
    public String fastest(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(pre))
                pre = pre.substring(0, pre.length() - 1);
        }
        return pre;

    }
}