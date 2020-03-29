package com.shri.demo;

import org.junit.Assert;
import org.junit.Test;

public class CurrentMethodName {


    @Test
    public void testNewObjectMethod() {
        String methodName = new Object() {
        }
                .getClass()
                .getEnclosingMethod()
                .getName();

        Assert.assertEquals("testNewObjectMethod", methodName);
    }

    @Test
    public void testCurrentTheadStack() {

        Assert.assertEquals("testCurrentTheadStack", getCurrentMethodName());
    }

    public static String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        return methodName;
    }
}
