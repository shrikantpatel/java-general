package com.shri.general.leet;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);

        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            randomNumbers.add(random.nextInt(101)); // Generates a random number between 0 and 100
        }

        //Get all keys from a Map as a Set.
        Set<String> keys = map.keySet().stream().collect(Collectors.toSet());
        keys.forEach(System.out::println);

        //Count elements in a List greater than 10.
        long result = randomNumbers.stream().filter(num -> num > 10).count();
        System.out.println(result);

        // count elements in a List greater than 10 and its sum
        result = randomNumbers.stream().filter(num -> num > 10).mapToInt(Integer::intValue).sum();
        System.out.println(result);

    }
}
