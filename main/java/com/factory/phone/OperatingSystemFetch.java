package com.factory.phone;

import com.spring.designPattern.Android;
import com.spring.designPattern.IOS;
import com.spring.designPattern.Windows;

public class OperatingSystemFetch {
    public OS getInstance(String string){
        if(string.equals("Open")) {
            return new Android();
        }
        else if(string.equals("close")){
            return new IOS();
        }else{
            return new Windows();
        }
    }
}
