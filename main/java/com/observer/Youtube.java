package com.observer;

public class Youtube {
    public static void main(String[] args) {

        Channel arpitha = new Channel();

        Subscriber Firstsubscriber = new Subscriber("Akshay");
        Subscriber Secondsubscriber = new Subscriber("Amulya");
        Subscriber Thirdsubscriber = new Subscriber("Ananya");
        Subscriber Fourthsubscriber = new Subscriber("Akash");
        Subscriber Fifthsubscriber = new Subscriber("Adithya");

        arpitha.subscriber(Firstsubscriber);
        arpitha.subscriber(Secondsubscriber);
        arpitha.subscriber(Thirdsubscriber);
        arpitha.subscriber(Fourthsubscriber);
        arpitha.subscriber(Fifthsubscriber);

        arpitha.unsubscribe(Fourthsubscriber);

        Firstsubscriber.subscribeChannel(arpitha);
        Secondsubscriber.subscribeChannel(arpitha);
        Thirdsubscriber.subscribeChannel(arpitha);
        Fourthsubscriber.subscribeChannel(arpitha);
        Fifthsubscriber.subscribeChannel(arpitha);

        arpitha.upload("How to learn programmimg");

    }
}
