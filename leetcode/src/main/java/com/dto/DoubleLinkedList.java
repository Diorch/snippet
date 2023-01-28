package com.dto;

public class DoubleLinkedList {
    // 头节点
    private LinkNode dummyHead = new LinkNode(null, null);
    private LinkNode tail = dummyHead;

    //得到头结点
    public LinkNode getHead() {
        return dummyHead.next;
    }

    //添加节点到末尾
    public void add(LinkNode myNode) {
        tail.next = myNode;
        myNode.prev = tail;
        tail = myNode;
    }

    //移除当前节点
    public void removeLinkNode(LinkNode myNode) {
        myNode.prev.next = myNode.next;
        //判断删除的是否是尾节点
        if (myNode.next != null) {
            myNode.next.prev = myNode.prev;
        } else {
            tail = myNode.prev;
        }
        //全部指向 null
        myNode.prev = myNode.next = null;
    }

    //移动当前节点到末尾
    public void moveToTail(LinkNode myNode) {
        removeLinkNode(myNode);
        add(myNode);
    }
}
