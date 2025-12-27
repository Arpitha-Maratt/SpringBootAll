package com.java8.usingLambdaExpression;


import com.java8.interfcaeUsingImplementation.Bird;

public class BirdMain {
    public static void main(String[] args) {

        Bird egale = (String value)->{
            System.out.println("EAGALE IMPLEMENTAION");
        };
        egale.canFly("verticle");
    }
}
