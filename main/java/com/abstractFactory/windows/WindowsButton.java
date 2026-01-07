package com.abstractFactory.windows;

import com.abstractFactory.functionality.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}
