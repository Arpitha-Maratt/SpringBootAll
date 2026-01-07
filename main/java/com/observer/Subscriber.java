package com.observer;

public class Subscriber implements Observer {
    private String name;
    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(){
        System.out.println("Hey "+ name+ " Videos uploaded"+ channel.title);
    }
    @Override
    public void subscribeChannel(Channel channel){
        this.channel = channel;
    }


}
