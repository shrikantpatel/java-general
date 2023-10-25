package com.shri.general.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        Collection<Integer> col = Arrays.asList(10, 2, 10, 9, 5);
        Integer test = col.stream().reduce(0, (subtotal, element) -> subtotal+element);
        System.out.println("Sum of integer - " + test);
        test = col.stream().reduce(0, Integer::sum);
        System.out.println("Sum of integer - " + test);

        Stream<Integer> randomNumbers = Stream
                .generate(() -> (new Random()).nextInt(100));

        randomNumbers.limit(2).forEach(System.out::println);
    }
}