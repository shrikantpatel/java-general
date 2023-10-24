package com.shri.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CurrentMethodName {


    @Test
    public void testNewObjectMethod() {
        String methodName = new Object() {
        }
                .getClass()
                .getEnclosingMethod()
                .getName();

        assertEquals("testNewObjectMethod", methodName);
    }

    @Test
    public void testCurrentTheadStack() {

        assertEquals("testCurrentTheadStack", getCurrentMethodName());
    }

    public static String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        return methodName;
    }
}
