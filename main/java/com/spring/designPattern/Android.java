package com.spring.designPattern;

import com.factory.phone.OS;

public class Android implements OS
{
    public void spec(){
        System.out.println("Most Powerful OS");
    }
}
