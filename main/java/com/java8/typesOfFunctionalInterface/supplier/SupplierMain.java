package com.java8.typesOfFunctionalInterface.supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<String> isEvenNumber = () -> "this is the dat i am returing";
        System.out.println(isEvenNumber.get());
    }
}
