package com.interv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * lru
 */

class xiaohongshu1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to online interview system of Acmcoder.");
        strings.add("This system is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }

        int a, b;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.printf("Your result is : %d", a + b);
        }
    }

    static class Node {
        public int key;
        public int val;
        Node prev;
        Node next;

        public Node() {

        }
        // getter
        // setter
    }

    static class LinkedList {
        Node dummy = new Node();
        Node tail = new Node();
        int capacity;

        public LinkedList() {

        }

        public Node getHead() {
            return dummy.next;
        }

        public void add() {

        }

        public void remove() {

        }

        public void removeToTail() {

        }

        static class Lru {
            Map<Integer, Node> map = new HashMap<>();
            LinkedList l;
            int capacity;

            public Lru(int capacity) {
                this.capacity = capacity;
                l = new LinkedList();
            }

            public void add(Node n) {

                if (!map.containsKey(n.key) && map.size() < capacity) {
                    // 当前值不存在且容量未满
                    Node temp = l.dummy.next;
                    l.dummy.next = n;
                    n.next = temp;
                    map.put(n.key, n);
                }
                else if (!map.containsKey(n.key) && map.size() >= capacity) {
                    // 当前值不存在且容量满
                    map.remove(l.tail.key);
                    removeTail(l);
                    Node temp = l.dummy.next;
                    l.dummy.next = n;
                    n.next = temp;
                    map.put(n.key, n);
                }
            }

            public Node get(Node node) {
                if (map.containsKey(node.key)) {
                    // 移动当前节点值链头

                    return map.get(node.key);
                }
                return null;
            }

            public void removeTail(LinkedList l) {

            }
        }
    }
}
