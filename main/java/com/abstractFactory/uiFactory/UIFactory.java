package com.abstractFactory.uiFactory;

import com.abstractFactory.functionality.Button;
import com.abstractFactory.functionality.CheckBox;

public interface UIFactory {
    Button createButton();

    CheckBox createCheckBox();
}
