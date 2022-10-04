package com.others;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LruCache {

    public static void main(String[] args) {

    }

    class Node {
        int key, value;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = this;
            next = this;
        }
    }

    private final int capacity;
    private Node dummy;
    private Map<Integer, Node> cache;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.dummy = new Node(0, 0);
        this.cache = new ConcurrentHashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                cache.remove(dummy.next.key);
                remove(dummy.next);
            }
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        } else {
            cache.remove(node.key);
            remove(node);
            node = new Node(key, value);
            cache.put(key, node);
            add(node);
        }
    }

    private void add(Node node) {
        dummy.pre.next = node;
        node.pre = dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}