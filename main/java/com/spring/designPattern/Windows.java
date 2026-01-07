package com.spring.designPattern;

import com.factory.phone.OS;

public class Windows  implements OS {

    @Override
    public void spec() {
        System.out.println("Iam about to die");
    }
}
