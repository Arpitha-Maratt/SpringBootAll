package com.java8.typesOfFunctionalInterface.function;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}
