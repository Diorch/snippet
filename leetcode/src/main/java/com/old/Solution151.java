package com.old;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 
 * 示例 1：
 * 
 * 输入: "the sky is blue" 输出: "blue is sky the" 示例 2：
 * 
 * 输入: " hello world! " 输出: "world! hello" 解释:
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 * 
 * 输入: "a good example" 输出: "example good a" 解释:
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 说明：
 * 
 * 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * @author yedc@zhongmakj.com Date: 2019/1/7 11:51
 */
public class Solution151 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        final Solution151 solution = new Solution151();

        String s = " the  sky  is blue ";
        final String s1 = solution.reverseWords2(s);
        System.out.println(s1);

    }

    public String reverseWords2(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }
        s = s.trim();
        final String[] split = s.split("\\s+");

        int i = split.length;
        final StringBuilder stringBuilder = new StringBuilder();

        while (i-- > 0) {

            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public String reverseWords1(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }
        s = s.trim();
        String result = "";
        final char[] chars = s.toCharArray();
        int length = chars.length;

        StringBuilder word = new StringBuilder();
        int i = 0;
        int flag = 0;
        while (i < length) {
            if (chars[i] == ' ') {
                if (flag == 0) {
                    result = word + " " + result;
                    word = new StringBuilder();
                }
                flag++;
            } else {
                word.append(String.valueOf(chars[i]));
                flag = 0;
            }

            i++;
        }

        result = word + " " + result;

        return result.trim();
    }

}
