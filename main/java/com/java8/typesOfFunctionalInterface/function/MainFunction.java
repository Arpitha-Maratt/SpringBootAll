package com.java8.typesOfFunctionalInterface.function;

public class MainFunction {
    public static void main(String[] args) {
        Function<Integer ,String>  interToString =
                (Integer num)->{
            String output = new String();
            return output;
                };
        System.out.println(interToString.apply(45));
    }
}
