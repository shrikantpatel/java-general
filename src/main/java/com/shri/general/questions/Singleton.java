package com.shri.general.questions;

public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
        if (instance != null) {
            throw new RuntimeException("Dont get constructor to get instance for singleton !!");
        }
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
