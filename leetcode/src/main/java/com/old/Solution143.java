package com.old;

public class Solution143 {

    public static void main(String[] args) {
        Node a = new Node();
        a.val = 1;

        Node b = new Node();
        b.val = 2;
        a.next = b;

        Node c = new Node();
        c.val = 3;
        b.next = c;

        Node d = new Node();
        d.val = 4;
        c.next = d;

        sortLink(a);

    }

    static void sortLink(Node link) {
        if (link == null || link.next == null) {
            return;
        }
        Node a = link;
        Node b = link.next;
        link = link.next.next;
        while (link.next != null) {
            a.next = link;
            b.next = link.next;
            link = link.next.next;
        }

        Node r;
        while (a != null) {
            Node ta = a.next;
            Node tb = b.next;
            r = a;
            r.next = b;
            a = ta;
            b = tb;
        }
    }

    static class Node {
        int val;
        Node next;
    }
}