package com.old;

import com.dto.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 
 * @author yedc@zhongmakj.com Date: 2019/3/6 21:47
 */
public class Solution206 {

    public static void main(String[] args) {

        final ListNode a = new ListNode(1);
        final ListNode b = new ListNode(2);
        final ListNode c = new ListNode(3);
        final ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode res = solution2(a);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    // 遍历
    public static ListNode solution1(ListNode list) {
        ListNode prev = null;
        ListNode next = null;
        while (list != null) {
            next = list.next;
            list.next = prev;
            prev = list;
            list = next;
        }
        return prev;
    }

    // 递归
    public static ListNode solution2(ListNode list) {
        while (list == null || list.next == null) {
            return list;
        }
        ListNode temp = list.next;
        ListNode tail = solution2(list.next);
        list.next = null;
        temp.next = list;
        return tail;
    }

}
