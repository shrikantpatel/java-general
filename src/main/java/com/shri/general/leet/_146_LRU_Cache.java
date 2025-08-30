package com.shri.general.leet;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/lru-cache/description/
 * <p>
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class _146_LRU_Cache {

    Map<Integer, Integer> cache;
    int capacity;

    public _146_LRU_Cache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {

        if (!cache.containsKey(key)) return -1;

        return cache.get(key);

    }

    public void put(int key, int value) {
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            // Evict the least recently used item
            Integer leastUsedKey = 0;
            cache.remove(leastUsedKey);
        }
        cache.put(key, value);
    }

    @Test
    public void testBasicPutAndGet() {
        _146_LRU_Cache cache = new _146_LRU_Cache(2);

        cache.put(1, 1); // cache = {1=1}
        cache.put(2, 2); // cache = {1=1, 2=2}
        assertEquals(1, cache.get(1)); // returns 1

        cache.put(3, 3); // evicts key 2, cache = {1=1, 3=3}
        assertEquals(-1, cache.get(2)); // returns -1 (not found)

        cache.put(4, 4); // evicts key 1, cache = {4=4, 3=3}
        assertEquals(-1, cache.get(1)); // returns -1 (not found)
        assertEquals(3, cache.get(3)); // returns 3
        assertEquals(4, cache.get(4)); // returns 4
    }

}
