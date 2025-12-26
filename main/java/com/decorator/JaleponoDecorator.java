package com.decorator;

public class JaleponoDecorator extends PizzaDecorator {
    public JaleponoDecorator(Pizza pizza) {
        super(pizza);
    }
    public String bake(){
        return pizza.bake() + addJalpano();
    }
    public String addJalpano(){
        return "jalepano";
    }
}
