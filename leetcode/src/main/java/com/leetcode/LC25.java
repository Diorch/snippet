package com.leetcode;

/**
 * @author diorch
 */
public class LC25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 表示要进行倒置的子链表，初始赋值head，一开始整条链表是要进行倒置的子链表
        ListNode subhead = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 表示已经倒置后的链表的尾部
        ListNode tail = dummy;
        // 为了将子链表从原来链表中取下来
        ListNode toNull = head;

        while (subhead != null) {
            int i = k;
            //找到子链表的尾部
            while (i - 1 > 0) {
                toNull = toNull.next;
                if (toNull == null) {
                    return dummy.next;
                }
                i--;
            }
            ListNode temp = toNull.next;
            //将子链表断开
            toNull.next = null;
            ListNode newSubHead = reverse(subhead);
            //将倒置后的链表接到 tail 后边
            tail.next = newSubHead;
            //更新 tail
            tail = subhead; //subhead 由于倒置其实是新链表的尾部
            subhead = temp;
            toNull = subhead;
            //将后边断开的链表接回来
            tail.next = subhead;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode currentHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = currentHead;
            currentHead = head;
            head = next;
        }
        return currentHead;
    }

    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
