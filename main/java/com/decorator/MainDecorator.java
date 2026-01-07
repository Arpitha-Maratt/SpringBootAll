package com.decorator;

public class MainDecorator {
    public static void main(String[] args) {
        Pizza pizza = new JaleponoDecorator(new CheeseBurstDecorator(new BasePizza()));
        System.out.println(pizza.bake());
    }
}
