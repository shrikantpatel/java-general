package com.shri.questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Bicycle {

    void run() {
        System.out.println("super class run");
    }

    static void ride() {
        System.out.println("super class ride");
    }

}

public class Hero extends Bicycle {
    void run() {
        System.out.println("sub class run ");
    }

    static void ride() {
        System.out.println("sub class ride");
    }

    public static void main(String args[]) {
        Bicycle b = new Hero();
        b.run();
        b.ride();
        int[] arr = new int[5];
        Arrays.stream(arr).boxed().collect(Collectors.toList()).forEach(System.out::println);
        List<String> list = Arrays.asList("a", "bb", "ccc", "ddddd", "a");
        Set<String> set = list.stream().distinct().collect(Collectors.toSet());
        Collections.sort(list);
        list.sort(Comparator.naturalOrder());
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }
}