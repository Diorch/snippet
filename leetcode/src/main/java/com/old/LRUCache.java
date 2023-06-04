package com.old;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String[] args) {

        //TODO auto generating..
        final LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));
        // lruCache.put(4, 4);
        // System.out.println(lruCache.get(1));
        // System.out.println(lruCache.get(3));
        // System.out.println(lruCache.get(4));

    }

    static class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode pre;

        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public ListNode() {

        }
    }

    int capacity;
    Map<Integer, ListNode> cache = new HashMap<Integer, ListNode>();

    private ListNode head;
    private ListNode tail;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        else {
            ListNode node = cache.get(key);
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode n = cache.get(key);
            moveToHead(n);
        }
        else {
            if (size >= capacity) {
                final ListNode removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
            ListNode n = new ListNode(key, value);
            addToHead(n);
            cache.put(key, n);
            size++;
        }
    }

    private void moveToHead(ListNode node) {
        deleteNode(node);
        addToHead(node);
    }

    private void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(ListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }

    private ListNode removeTail() {
        ListNode tmp = tail.pre;
        deleteNode(tmp);
        return tmp;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */