package base.queue;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jbzm
 * @date 8/7/20 12:44 AM
 **/
public class LRUCache {
    private HashMap<Integer, Integer> integerIntegerHashMap;
    private Queue<Integer> queue;
    private int capacity;

    public LRUCache(int capacity) {
        integerIntegerHashMap = new LinkedHashMap<>(capacity);
        queue = new LinkedBlockingQueue<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer integer = integerIntegerHashMap.get(key);
        if (integer == null) {
            return -1;
        }
        queue.remove(key);
        queue.offer(key);
        return integer;
    }

    public void put(int key, int value) {
        if (integerIntegerHashMap.containsKey(key)) {
            integerIntegerHashMap.put(key, value);
            queue.remove(key);
            queue.offer(key);
        } else if (integerIntegerHashMap.size() < capacity) {
            integerIntegerHashMap.put(key, value);
            queue.offer(key);
        } else {
            Integer poll = queue.poll();
            integerIntegerHashMap.remove(poll);
            integerIntegerHashMap.put(key, value);
            queue.offer(key);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(1);
        lruCache.put(3, 3);
//        lruCache.put(4, 4);
//        lruCache.put(5, 5);
//        lruCache.put(6, 6);
//        lruCache.put(7, 7);
//        lruCache.put(8, 8);
//        lruCache.put(9, 9);
//        lruCache.put(0, 0);
        System.out.println(i);
        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(13));
    }
}