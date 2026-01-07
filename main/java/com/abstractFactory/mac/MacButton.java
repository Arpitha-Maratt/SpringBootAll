package com.abstractFactory.mac;

import com.abstractFactory.functionality.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac Button");
    }
}
