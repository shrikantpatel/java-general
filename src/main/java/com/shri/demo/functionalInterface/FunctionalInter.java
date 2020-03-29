package com.shri.demo.functionalInterface;

@FunctionalInterface
public interface FunctionalInter<T> {

    public void test(T t);

    /*
        Conceptually, a functional interface has exactly one abstract method. Since default methods have an implementation,
        they are not abstract. If an interface declares an abstract method overriding one of the public methods of java.lang.Object,
        that also does not count toward the interface's abstract method count since any implementation of the interface will have
        an implementation from java.lang.Object or elsewhere. Note that instances of functional interfaces can be created
        with lambda expressions, method references, or constructor references.
     */
    public boolean equals(Object obj);
}
