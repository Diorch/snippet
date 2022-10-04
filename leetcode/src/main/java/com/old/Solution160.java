package com.old;

import com.dto.ListNode;

import java.util.Stack;


public class Solution160 {

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode b1 = new ListNode(10);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        // b1.next = a6;
        ListNode res = solution02(a1, b1);
        if (res == null) {
            System.out.println("no intersection point.");
        } else {
            while (res != null) {
                System.out.println(res.val);
                res = res.next;
            }
        }

    }

    // 双指针
    public static ListNode solution01(ListNode aList, ListNode bList) {
        if (aList == null || bList == null) {
            return null;
        }

        ListNode res = null;
        ListNode p1 = aList, p2 = bList;

        while (aList != null || bList != null) {

            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;

            if (p1.next == null) {
                p1 = bList;
            }
            if (p2.next == null) {
                p2 = aList;
            }
            if (p1 == p2) {
                return p1;
            }
        }
        return res;
    }

    // 双指针leetcode官方版
    static ListNode solution03(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode L = headA;
        ListNode R = headB;
        int count = 0;

        while (L != R) {
            L = L.next;
            R = R.next;

            if (L == null) {
                L = headB;
                count++;
            }
            if (R == null) {
                R = headA;
                count++;
            }
            if (count > 2) {
                return null;
            }
        }
        return L;
    }

    // 栈
    public static ListNode solution02(ListNode aList, ListNode bList) {
        Stack<ListNode> aStack = new Stack<>();
        Stack<ListNode> bStack = new Stack<>();
        while (aList != null) {
            aStack.push(aList);
            aList = aList.next;
        }
        while (bList != null) {
            bStack.push(bList);
            bList = bList.next;
        }

        ListNode res = null;
        while (!aStack.empty() && !bStack.isEmpty()) {
            res = aStack.peek();
            if (aStack.pop() != bStack.pop()) {
                break;
            }

        }
        return res.next;
    }
}