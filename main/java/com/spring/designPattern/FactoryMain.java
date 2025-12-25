package com.spring.designPattern;

import com.factory.phone.OS;
import com.factory.phone.OperatingSystemFetch;

public class FactoryMain {
    public static void main(String[] args)
    {
        OperatingSystemFetch osf = new OperatingSystemFetch();
        OS obj = osf.getInstance("ntg");
        obj.spec();
    }
}
