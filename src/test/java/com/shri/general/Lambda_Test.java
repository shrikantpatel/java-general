package com.shri.general;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambda_Test {

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
        Assert.assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectLinkedList() {
        String[] test = {"test", "", "test1", "test2", "cat" };
        List<String> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).collect(Collectors.toCollection(LinkedList::new));
        Assert.assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectSet() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Set<String> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).collect(Collectors.toSet());
        Assert.assertEquals(3, test1.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testFilterAndCollectMapExceptionBecauseOfDuplicate() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        Assert.assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectMap() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length, (existing, newOne) -> existing));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        Assert.assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectConcurrentMap() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length, (existing, newOne) -> existing, ConcurrentHashMap::new));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        Assert.assertEquals(3, test1.size());
    }

    @Test
    public void testFilterAndCollectTreeMap() {
        String[] test = {"test", "test", " ", "test1", "test1", "test2", "cat" };
        Map<String, Integer> test1 = Arrays.stream(test).filter(s -> s.trim().contains("test")).
                collect(Collectors.toMap(Function.identity(), String::length, (existing, newOne) -> existing, TreeMap::new));
        test1.forEach((k, v) -> System.out.println(k + " --> " + v));
        Assert.assertEquals(3, test1.size());
    }

    @Test
    public void testMap() {
        Integer[] test = {1, 2, 3, 4};
        Integer[] ans = {2, 4, 6, 8};
        List<Integer> test1 = Arrays.stream(test).map(s -> s*2).collect(Collectors.toList());
        Assert.assertArrayEquals(Arrays.stream(ans).mapToInt(i->i).toArray() , test1.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void testReduceApproach1() {
        Integer[] test = {1, 2, 3, 4};
        int total =  Arrays.stream(test).reduce(0 , (subtotal, i) -> subtotal+i);
        Assert.assertEquals(10, total);
    }

    @Test
    public void testReduceApproach2() {
        Integer[] test = {1, 2, 3, 4};
        int total =  Arrays.stream(test).reduce(0 , Integer::sum);
        Assert.assertEquals(10, total);
    }


}
