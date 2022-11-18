package com.leetcode;

import com.dto.DoubleLinkedList;
import com.dto.LinkNode;

import java.util.HashMap;

/**
 * LRU缓存机制（LRU Cache）
 *
 * Node：key，value，带前后指针
 * LinkList：
 *      定义tail，指向尾节点
 *      定义dummyHead，其next指向真正头结点
 *      get，获取dummyHead的next
 *      add，添加至尾部
 *      remove，移除，若是尾节点则需要对tail指针重新赋值，否则，仅移除节点
 *      moveToTail，remove后再add
 * LRU：
 *      定义capacity
 *      定义map存放键值对，O(1)复杂
 *      定义list，操控LRU策略
 *      get，获取制定键的值，且将该节点移至链表末尾
 *      put，
 *          若键不存在，添加新键值对至链表末尾
 *          若键存在，
 *              - capacity已满，则链表移除头结点，map移除对应key。插入新节点至链表队尾，添加新节点至map
 *              - capacity未满，则插入新节点至链表队尾，添加新节点至map
 *
 * @author diorch
 */
public class LC146 {

    private int capacity = 0;
    private HashMap<Integer, LinkNode> map = new HashMap<>();
    private DoubleLinkedList list = new DoubleLinkedList();

    public LC146(int capacity) {
        this.capacity = capacity;
    }

    //get 的同时要把当前节点移动到末尾
    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode myNode = map.get(key);
            list.moveToTail(myNode);
            return (int) myNode.value;
        } else {
            return -1;
        }
    }

    //对于之前存在的节点单独考虑
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkNode myNode = map.get(key);
            myNode.value = value;
            list.moveToTail(myNode);
        } else {
            //判断是否存满
            if (map.size() == capacity) {
                //从 map 和 list 中都删除头结点
                LinkNode head = list.getHead();
                map.remove((int) head.key);
                list.removeLinkNode(head);
                //插入当前元素
                LinkNode myNode = new LinkNode(key, value);
                list.add(myNode);
                map.put(key, myNode);
            } else {
                LinkNode myNode = new LinkNode(key, value);
                list.add(myNode);
                map.put(key, myNode);
            }
        }
    }
}
