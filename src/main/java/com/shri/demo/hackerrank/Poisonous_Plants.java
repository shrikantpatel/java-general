package com.shri.demo.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Poisonous_Plants {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
class Result {

    /*
     * Complete the 'poisonousPlants' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int poisonousPlants(List<Integer> p) {

        int days = 0;
        while (plantOnLeftLessPoisnous(p)) {
            p = removePoisnousPlant(p);
            days++;
        }
        return days;
    }

    public static List<Integer> removePoisnousPlant(List<Integer> p) {

        List<Integer> newArray = new ArrayList();
        newArray.add(p.get(0));
        for (int i = 1 ; i < p.size(); i++) {
            if (p.get(i) <= p.get(i-1)) {
                newArray.add(p.get(i));
            }
        }
        System.out.println(); newArray.forEach(c -> System.out.print(c + " "));
        return newArray;
    }

    public static boolean plantOnLeftLessPoisnous(List<Integer> p) {

        for (int i = 1 ; i < p.size(); i++) {
            if (p.get(i) > p.get(i-1)) {
                return true;
            }
        }
        return false;
    }
}