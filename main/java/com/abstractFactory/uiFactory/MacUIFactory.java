package com.abstractFactory.uiFactory;

import com.abstractFactory.functionality.Button;
import com.abstractFactory.functionality.CheckBox;
import com.abstractFactory.mac.MacButton;
import com.abstractFactory.mac.MacCheckBox;


public class MacUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
