package com.abstractFactory.builderPhone;

public class Phone {
    private String os;
    private int ram;
    private String proceesor;
    private Double screenSize;
    private int battery;

    public Phone(String os, int battery, Double screenSize, String proceesor, int ram) {
        this.os = os;
        this.battery = battery;
        this.screenSize = screenSize;
        this.proceesor = proceesor;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", proceesor='" + proceesor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }
}
