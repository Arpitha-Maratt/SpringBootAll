package com.abstractFactory.builderPhone;

public class PhoneBuilder {
    private String os;
    private int ram;
    private String proceesor;
    private Double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public PhoneBuilder setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setProceesor(String proceesor) {
        this.proceesor = proceesor;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }
    public Phone getPhone(){
        return new Phone(os,ram,screenSize,proceesor,battery);
    }
}
