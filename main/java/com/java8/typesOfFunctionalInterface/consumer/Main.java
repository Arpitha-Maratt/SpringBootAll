package com.java8.typesOfFunctionalInterface.consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<Integer> logging = (Integer val)->
        {
            if(val >10){
                System.out.println("logging");
            }
        };
        logging.accept(11);
    }
}
