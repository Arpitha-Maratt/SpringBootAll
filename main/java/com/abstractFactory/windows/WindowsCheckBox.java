package com.abstractFactory.windows;

import com.abstractFactory.functionality.CheckBox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Windows checkBox");
    }
}
