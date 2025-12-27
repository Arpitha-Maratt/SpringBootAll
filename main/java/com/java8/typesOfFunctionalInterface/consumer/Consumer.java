package com.java8.typesOfFunctionalInterface.consumer;

@FunctionalInterface
public interface Consumer<T>{
    void accept(T t);
}
