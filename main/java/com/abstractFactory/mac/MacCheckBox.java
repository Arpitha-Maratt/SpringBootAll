package com.abstractFactory.mac;

import com.abstractFactory.functionality.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Mac Checkbox");
    }
}
