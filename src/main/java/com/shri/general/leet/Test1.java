package com.shri.general.leet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test1 {

    public static void main(String[] args) {

        System.out.println('A'-'a');

        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numList.add(i); // Generates a random number between 0 and 100
        }

        List<String> stringList = new ArrayList<>(Arrays.asList("cat", "dog", "apple", "bat", "banana", "rat", "zoro"));
        int[] numArray = new int[]{1, 2, 3, 5, 6};

        //Get all keys from a Map as a Set.
        Set<String> keys = new HashSet<>(map.keySet());
        keys.forEach(x -> System.out.print(x + ", "));
        System.out.println();

        //Count elements in a List greater than 10.
        long result = numList.stream().filter(num -> num > 10).count();
        System.out.println(result);

        // count elements in a List greater than 10 and its sum
        result = numList.stream().filter(num -> num > 10).mapToInt(Integer::intValue).sum();
        System.out.println(result);

        // Convert a List of Integer to their squares.
        numList.stream().map(x -> x * x).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // Get distinct elements from a List.
        numList.stream().distinct().forEach(x -> System.out.print(x + ", "));
        System.out.println();


        // Sort a List of Strings alphabetically.
        stringList.stream().sorted().forEach(x -> System.out.print(x + ", "));
        System.out.println();
        stringList.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // Find the maximum value in a List.
        System.out.println(numList.stream().max(Comparator.naturalOrder()));

        // Convert all strings in a List to uppercase.
        List<String> list = stringList.stream().map(String::toUpperCase).toList();
        list.forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // Count elements in an array equal to a given value.
        System.out.println(numList.stream().filter(x -> x == 9).count());

        // Remove nulls from a List.
        stringList.add(null);
        stringList.stream().filter(Objects::nonNull).forEach(x -> System.out.print(x + ", "));
        stringList.remove(null);
        System.out.println();

        // Filter even numbers from a List.
        numList.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        //Get List of lengths of each String in a List.
        stringList.stream().map(String::length).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        //Reverse sort a List of numbers
        numList.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + ", "));
        System.out.println();

        // Join a List of Strings into a single comma-separated String.
        System.out.println(stringList.stream().reduce((s1, s2) -> s1 + "," + s2).orElse(""));

        //*** Create a Map of word length to count from a List of words.
        Map<Integer, Long> lengthToCount = stringList.stream().collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));
        lengthToCount.forEach((key, value) -> System.out.println("Length: " + key + ", Count: " + value));

        //** Get top 3 longest words from a List.
        String result1 = stringList.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .limit(3)
                .collect(Collectors.joining(", "));
        System.out.println(result1);

        //*** Convert an array of ints to a List.
        Arrays.stream(numArray).boxed().toList().forEach(x -> System.out.print(x + ", "));
        System.out.println();

        //** Get index of first String containing "z".
        System.out.println(stringList.stream().filter(s -> s.contains("z")).findFirst().orElse(""));
        int index = IntStream.range(0, stringList.size())
                .filter(i -> stringList.get(i).contains("z"))
                .findFirst().orElse(-1);
        System.out.println("index " + index);

        // Find sum of squares of odd numbers in a List.
        System.out.println(
                numList.stream()
                        .filter(x -> (x % 2 != 0))
                        .map(i -> i * i)
                        .reduce(Integer::sum)
                        .orElse(-1));

        // Replace all "foo" in a List with "bar".
        List<String> test1 = Arrays.asList("foo", "zoo", "foo");
        System.out.println(test1.stream()
                .map(s -> "foo".equals(s) ? "bar" : s)
                .collect(Collectors.joining(",")));

        ListIterator<String> it = test1.listIterator();
        while (it.hasNext()) {
            if ("foo".equals(it.next())) {
                it.set("bar");
            }
        }
        System.out.println(test1);

        // Get List of all email domains from a List of emails.
        List<String> emails = Arrays.asList(
                "alice@gmail.com",
                "bob@yahoo.com",
                "carol@amazon.com",
                "dave@gmail.com"
        );
        List<String> domains = emails.stream()
                .map(email -> email.substring(email.indexOf('@') + 1))
                .distinct().toList();
        System.out.println(domains);

        // Zip the lists into a Map (keys from first list, values from second list)
        List<String> keys1 = Arrays.asList("Alice", "Bob", "Carol");
        List<Integer> values = Arrays.asList(23, 35, 40);

        Map<String, Integer> zippedMap = IntStream.range(0, Math.min(keys1.size(), values.size()))
                .boxed()
                .collect(Collectors.toMap(keys1::get, values::get));
        System.out.println(zippedMap);

        for (int i = 0; i < Math.min(keys.size(), values.size()); i++) {
            zippedMap.put(keys1.get(i), values.get(i));
        }
        System.out.println(zippedMap);


    }
}
