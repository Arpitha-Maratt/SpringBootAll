package com.abstractFactory;

import com.abstractFactory.functionality.Button;
import com.abstractFactory.functionality.CheckBox;
import com.abstractFactory.uiFactory.UIFactory;

public class MainFactory {

        private Button button;
        private CheckBox checkBox;

        public MainFactory(UIFactory factory){
        button = factory.createButton();
        checkBox = factory.createCheckBox();
        }

        public void paint(){
            button.paint();
            checkBox.paint();
        }
}

