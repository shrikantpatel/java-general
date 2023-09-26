package com.shri.general.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        Collection<Integer> col = Arrays.asList(10, 2, 10, 9, 5);
        Integer test = col.stream().reduce(0, (subtotal, element) -> subtotal+element);
        System.out.println(test);

    }
}
