package com.singleton;

public class EgerSingleton {

    private static EgerSingleton instance = new EgerSingleton();

    private EgerSingleton(){

    }
    public static EgerSingleton getInstance(){
        return instance;
    }
}
