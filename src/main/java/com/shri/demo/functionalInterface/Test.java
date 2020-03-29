package com.shri.demo.functionalInterface;

public class Test {

    public static void testFunctional(FunctionalInter<String> f) {
        f.test("test");
    }

    public static void main(String[] args) {

        testFunctional(s -> System.out.println(s));
        testFunctional(System.out::println);
        testFunctional(new FunctionalInter<String>() {
            @Override
            public void test(String s) {
                System.out.println(s);
            }
        });

    }
}
