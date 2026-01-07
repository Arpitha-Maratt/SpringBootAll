package com.spring.designPattern;

import com.factory.phone.OS;

public class IOS implements OS {

    @Override
    public void spec(){
        System.out.println("Most powerfull OS IOS");
    }

}
