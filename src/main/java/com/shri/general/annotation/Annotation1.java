package com.shri.general.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
/*
 this is important and if this is not set, its not retented during runtime and nothing prints below
 */
@Retention(RetentionPolicy.RUNTIME)

public @interface Annotation1 {

    String author();
    int currentVersion() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
}


