package com.abstractFactory;

import com.abstractFactory.uiFactory.MacUIFactory;

public class Main {
    public static void main(String[] args) {
        MainFactory mainFactory
                = new MainFactory(new MacUIFactory());
        mainFactory.paint();
    }
}
