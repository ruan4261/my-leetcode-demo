package com.ruan.alg.leetcode.leetcode.q146;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 );// 缓存容量
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);        返回  1
 * cache.put(3,3);     该操作会使得密钥 2 作废
 * cache.get(2);        返回 -1 (未找到)
 * cache.put(4,4);     该操作会使得密钥 1 作废
 * cache.get(1);        返回 -1 (未找到)
 * cache.get(3);        返回  3
 * cache.get(4);        返回  4
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ruan4261
 */
public class LRUCache {

    private final HashMap<Integer, Node> cache;

    private final Node head;

    private final Node tail;

    private final int maxSize;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.maxSize = capacity;
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-1, -1, head, null);
        head.next = tail;
    }

    public int get(int key) {
        Node v = cache.get(key);
        if (v == null) return -1;
        removeToHead(v);
        return v.val;
    }

    public void put(int key, int value) {
        Node v = cache.get(key);
        if (v != null) {
            v.val = value;
            removeToHead(v);
        } else {
            if (cache.size() == maxSize) removeTail();
            Node node = new Node(key, value, null, null);
            addToHead(node);
            cache.put(key, node);
        }
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }

    private void removeToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeTail() {
        cache.remove(tail.prev.key);
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
    }

}
