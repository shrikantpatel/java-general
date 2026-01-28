package com.shri.general.leet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 */
public class _981_Time_Based_Key_Value_Store {

    private final Map<String, List<Pair>> map;

    public _981_Time_Based_Key_Value_Store() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.get(key);
        if (list == null) return null;
        String result = "";

        int left = 0, right = list.size() - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;   // try to find a later timestamp
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static class Pair {
        String value;
        int timestamp;

        Pair(String key, int timestamp) {
            this.value = key;
            this.timestamp = timestamp;
        }
    }

    // ------------------------------------------------------------
    // JUnit 5 tests validating correctness (no solution included)
    // ------------------------------------------------------------
    @Nested
    class Tests {

        @Test
        void testBasicSetAndGet() {
            _981_Time_Based_Key_Value_Store store = new _981_Time_Based_Key_Value_Store();

            store.set("foo", "bar", 1);

            assertEquals("bar", store.get("foo", 1));
        }

        @Test
        void testGetEarlierTimestamp() {
            _981_Time_Based_Key_Value_Store store = new _981_Time_Based_Key_Value_Store();

            store.set("foo", "bar", 1);

            // Querying timestamp before any set → expect null
            assertNull(store.get("foo", 0));
        }

        @Test
        void testMultipleTimestamps() {
            _981_Time_Based_Key_Value_Store store = new _981_Time_Based_Key_Value_Store();

            store.set("foo", "bar", 1);
            store.set("foo", "bar2", 4);

            assertEquals("bar", store.get("foo", 3));

            assertEquals("bar2", store.get("foo", 4));

            assertEquals("bar2", store.get("foo", 100));
        }

        @Test
        void testMissingKey() {
            _981_Time_Based_Key_Value_Store store = new _981_Time_Based_Key_Value_Store();

            store.set("foo", "bar", 1);

            assertNull(store.get("unknown", 5));
        }

        @Test
        void testLeetCodeExample() {
            _981_Time_Based_Key_Value_Store store = new _981_Time_Based_Key_Value_Store();

            store.set("love", "high", 10);
            store.set("love", "low", 20);

            assertEquals("high", store.get("love", 10));

            assertEquals("high", store.get("love", 15));

            assertEquals("low", store.get("love", 20));

            assertEquals("low", store.get("love", 25));
        }

        @org.junit.jupiter.api.Test
        void testGetReturnsEmptyStringWhenKeyExistsButNoEarlierTimestamp() {
            _981_Time_Based_Key_Value_Store store =
                    new _981_Time_Based_Key_Value_Store();

            store.set("love", "high", 10);
            store.set("love", "low", 20);

            // Key exists, but no timestamp <= 5 exists
            assertEquals("", store.get("love", 5));
        }
    }
}