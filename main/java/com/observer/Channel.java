package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
    List<Subscriber> subscribers = new ArrayList<>();
     String title;

    @Override
    public void subscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    @Override
    public void unsubscribe(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(){
        for(Subscriber subscriber : subscribers){
            subscriber.update();
        }
    }
    @Override
    public void upload(String title){
       this.title = title;
       notifySubscribers();
    }

    @Override
    public String getTitle(){
        return title;
    }
}
