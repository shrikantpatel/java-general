package com.shri.general.leet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 * <p>
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * <p>
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * <p>
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * <p>
 * <p>
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class _49_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] inputArray) {

        Map<String, List<String>> map = new ConcurrentHashMap<>();

        // iterate through the string to character array. and sort character with in array.
        // use the sorted array as key in map
        // use sorted char array to find if key exist and add new value to map.
        // if sorted char array does not exist add new key.
        for (String input : inputArray) {
            char[] charArr = input.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if (map.containsKey(key)) {
                map.get(key).add(input);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(input);
                map.put(key, temp);
            }
        }

        // order the strings \ value part of the map using natural order
        for (String key : map.keySet()) {
            map.get(key).sort(Comparator.naturalOrder());
        }

        // convert the map to list and use size of the list to order final array
        List<List<String>> returnList = new ArrayList<List<String>>(map.values()).stream().
                                            sorted(Comparator.comparingInt(List::size)).collect(Collectors.toList());

        return returnList;
    }

    @Test
    public void test1() {
        _49_Group_Anagrams t = new _49_Group_Anagrams();
        String[] input = new java.lang.String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = Arrays.asList(Arrays.asList("bat"), Arrays.asList("nat", "tan"), Arrays.asList("ate", "eat", "tea"));
        assertEquals(output, t.groupAnagrams(input));
    }

    @Test
    public void test2() {
        _49_Group_Anagrams t = new _49_Group_Anagrams();
        String[] input = new java.lang.String[]{""};
        List<List<String>> output = Arrays.asList(Arrays.asList(""));
        assertEquals(output, t.groupAnagrams(input));
    }

    @Test
    public void test3() {
        _49_Group_Anagrams t = new _49_Group_Anagrams();
        String[] input = new java.lang.String[]{"a"};
        List<List<String>> output = Arrays.asList(Arrays.asList("a"));
        assertEquals(output, t.groupAnagrams(input));
    }

}
