package base.queue;

import java.util.LinkedHashMap;

/**
 * @author jbzm
 * @date 8/7/20 1:51 AM
 **/
public class LRUCustomLink {
    private LinkedHashMap<Integer, Node> integerLinkedHashMap;
    private Node headNode;
    private Node endNode;
    private int capacity;

    public LRUCustomLink(int capacity) {
        integerLinkedHashMap = new LinkedHashMap<>();
        headNode = new Node(-1, -1);
        endNode = new Node(-1, -1);
        headNode.nextNode = endNode;
        endNode.preNode = headNode;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!integerLinkedHashMap.containsKey(key)) {
            return -1;
        }

        Node node = integerLinkedHashMap.get(key);
        moveToNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (integerLinkedHashMap.containsKey(key)) {
            Node node = integerLinkedHashMap.get(key);
            node.data = key;
            node.value = value;
            moveToNode(node);
        } else if (integerLinkedHashMap.size() < capacity) {
            Node node = new Node(key, value);
            integerLinkedHashMap.put(key, node);
            addToHead(node);
        } else {
            Node preNode = endNode.preNode;
            integerLinkedHashMap.remove(preNode.data);
            preNode.data = key;
            preNode.value = value;
            integerLinkedHashMap.put(key, preNode);
            moveToNode(preNode);
        }
    }

    public void removeNode(Node node) {
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }

    public void addToHead(Node node) {
        node.nextNode = headNode.nextNode;
        node.preNode = headNode;
        headNode.nextNode.preNode = node;
        headNode.nextNode = node;
    }

    public void moveToNode(Node node) {
        removeNode(node);
        addToHead(node);
    }

    class Node {
        int data;
        int value;
        Node nextNode;
        Node preNode;

        Node(int data, int value) {
            this.data = data;
            this.value = value;
        }

        private void addRight(int data, int value) {
            Node node = new Node(data, value);
            this.nextNode = node;
        }

        private void addLeft(int data, int value) {
            Node node = new Node(data, value);
            this.preNode = node;
        }
    }

    public static void main(String[] args) {
        LRUCustomLink lruCache = new LRUCustomLink(2);
        lruCache.put(2, 6);
        System.out.println(lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
//        lruCache.put(4, 1);
        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(4));
//        lruCache.put(5, 5);
//        lruCache.put(6, 6);
//        lruCache.put(7, 7);
//        lruCache.put(8, 8);
//        lruCache.put(9, 9);
//        lruCache.put(0, 0);
//        System.out.println(lruCache.get(13));
    }

}