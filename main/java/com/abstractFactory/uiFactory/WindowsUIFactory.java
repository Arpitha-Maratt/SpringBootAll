package com.abstractFactory.uiFactory;

import com.abstractFactory.functionality.Button;
import com.abstractFactory.functionality.CheckBox;
import com.abstractFactory.windows.WindowsButton;
import com.abstractFactory.windows.WindowsCheckBox;

public class WindowsUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
