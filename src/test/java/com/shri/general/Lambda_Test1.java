package com.shri.general;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lambda_Test1 {

    @Test
    public void testBasic() {
        String[] test = {"test", "", "test2" };
        Arrays.stream(test).forEach(s -> {
            Optional.ofNullable(s).ifPresent(System.out::println);
        });
    }

    @Test
    public void testFilterAndCollectList() {
        String[] test = {"test", "", "test1", "test2", "cat" };
        List<String> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).collect(Collectors.toList());
        assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectLinkedList() {
        String[] test = {"test", "", "test1", "test2", "cat" };
        List<String> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).collect(Collectors.toCollection(LinkedList::new));
        assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectSet() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Set<String> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).collect(Collectors.toSet());
        assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectMap() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length, (existing, newOne) -> existing));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectConcurrentMap() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length, (existing, newOne) -> existing, ConcurrentHashMap::new));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectTreeMap() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length, (existing, newOne) -> existing, TreeMap::new));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        assertEquals(3, test1.size());
    }

    @Test
    public void testMap() {
        Integer[] test = {1, 2, 3, 4};
        Integer[] ans = {2, 4, 6, 8};
        List<Integer> test1 = Arrays.stream(test).map(s -> s*2).collect(Collectors.toList());
        assertArrayEquals(Arrays.stream(ans).mapToInt(i->i).toArray() , test1.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void testReduceApproach1() {
        Integer[] test = {1, 2, 3, 4};
        int total =  Arrays.stream(test).reduce(0 , (subtotal, i) -> subtotal+i);
        assertEquals(10, total);
    }

    @Test
    public void testReduceApproach2() {
        Integer[] test = {1, 2, 3, 4};
        int total =  Arrays.stream(test).reduce(0 , Integer::sum);
        assertEquals(10, total);
    }


}
