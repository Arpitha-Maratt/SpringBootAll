package com.singleton;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        exampleSerialization();

    }

    private static void exampleSerialization() throws IOException,ClassNotFoundException{
        LazySingleton lazySingleton= LazySingleton.getInstance();
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(lazySingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
       LazySingleton deserailzedLazy = (LazySingleton) objectInputStream.readObject();
       objectInputStream.close();

        System.out.println("Object 1:"+lazySingleton.hashCode());
        System.out.println("Object 2:"+lazySingleton.hashCode());


    }
}
