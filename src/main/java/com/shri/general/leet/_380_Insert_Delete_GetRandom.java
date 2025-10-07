package com.shri.general.leet;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class _380_Insert_Delete_GetRandom {

    private static _380_Insert_Delete_GetRandom.RandomizedSet randomizedSet;

    static class RandomizedSet {

        // List to store the elements (for O(1) access by index)
        List<Integer> values = new ArrayList<>();

        // HashMap to store the mapping from value to its index in the list
        HashMap<Integer, Integer> map = new HashMap<>();

        // Random instance used to generate random indexes
        Random random = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {

            // Check if value already exists in the map
            if (!map.containsKey(val)) {
                // Add value at the end of the list
                values.add(val);
                // Record the index of the newly added value in the map
                map.put(val, values.size() - 1);
                return true;
            }
            return false; // Value already present, no insertion
        }

        public boolean remove(int val) {

            if (map.containsKey(val)) {
                // Get the index of the value to remove
                int index = map.get(val);

                // If the element to remove is not the last one in the list
                if (index != values.size() - 1) {

                    // Get value of the last element in the list and move it to this index
                    int lastValue = values.getLast();
                    values.set(index, lastValue);
                    map.put(lastValue, index);
                }

                // Remove last element and update the map
                values.removeLast();
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int index = random.nextInt(values.size());
            return values.get(index);
        }
    }

    @BeforeEach
    public void setUp() {
        randomizedSet = new RandomizedSet();
    }

    @org.junit.jupiter.api.Test
    public void testInsert() {
        // Example test stub for insert method
        assertTrue(randomizedSet.insert(1));
        assertFalse(randomizedSet.insert(1));
    }

    @org.junit.jupiter.api.Test
    public void testRemove() {
        randomizedSet.insert(1);
        assertTrue(randomizedSet.remove(1));
        assertFalse(randomizedSet.remove(2));
    }

    @org.junit.jupiter.api.Test
    public void testGetRandom() {
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        int randomValue = randomizedSet.getRandom();
        assertTrue(randomValue == 1 || randomValue == 2);
    }


    @org.junit.jupiter.api.Test
    public void test2() {
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int randomValue = randomizedSet.getRandom();
        assertEquals(2, randomValue);
    }
}