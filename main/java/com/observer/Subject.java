package com.observer;

public interface Subject {
    void subscriber(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifySubscribers();

    void upload(String title);

    String getTitle();
}
