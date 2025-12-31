package com.shri.general.questions;

public enum SingletonUsingEnum {

    INSTANCE("test");
    private final String name;

    SingletonUsingEnum(String name){
        this.name = name;
    }

    public String getValue() {
        return name;
    }


}
