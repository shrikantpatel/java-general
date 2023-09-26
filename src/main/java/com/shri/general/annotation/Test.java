package com.shri.general.annotation;

import java.lang.annotation.Annotation;

@Annotation1(author = "spatel")
public class Test {

    @Annotation1(author = "spatel")
    public static void main (String[] args) {

        Annotation[] annotations = Test.class.getAnnotations();
        for (Annotation annonate : annotations) {
            System.out.println(annonate);
        }

    }
}
