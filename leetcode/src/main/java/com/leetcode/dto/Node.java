package com.leetcode.dto;

import com.ioutility.Reader;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author dechuye
 */
@Data
@ToString
public class Node {
    public int value;
    public Node next;

    public static void print(Node link) {
        if (link != null) {
            System.out.print(link.value);
            while (link.next != null) {
                System.out.print(" -> " + link.next.value);
                link = link.next;
            }
        }
        else {
            System.out.println("link is null");
        }
    }

    /**
     * 从控制台读取输入的整数，返回链表
     *
     * @return 与输入顺序相反的链表
     */
    public static Node buildLink() {
        final List<Integer> ints = Reader.ints();
        Node head = null;
        for (Integer i : ints) {
            Node added = new Node();
            added.value = i;
            Node next = head;
            head = added;
            head.next = next;
        }
        return head;
    }

}
