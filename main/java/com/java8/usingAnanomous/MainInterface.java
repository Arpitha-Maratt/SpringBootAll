package com.java8.usingAnanomous;

public class MainInterface {
    public static void main(String[] args) {

        Bird bird = new Bird() {
            @Override
            public void canFly(String val) {
                System.out.println("Egale implementation");
            }
        };
        bird.canFly("verticle");
    }
}
