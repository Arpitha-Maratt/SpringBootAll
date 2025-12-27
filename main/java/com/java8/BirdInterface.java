package com.java8;

@FunctionalInterface
public interface BirdInterface {
    void canFly();

    // here we cannot write another abstract method but we can add other methods

    default void getHigh(){

    }

//    can add toString
}
