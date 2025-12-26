package com.prototype;

public class MainPrototye {
    public static void main(String[] args) throws CloneNotSupportedException {

        BookShop bookShop = new BookShop();
        bookShop.setShopName("Novelty");
        bookShop.loadData();
        System.out.println(bookShop);


        BookShop bookShop1 = (BookShop) bookShop.clone();
        bookShop.getBooList().remove(2);
        bookShop1.setShopName("A1");

        System.out.println(bookShop);
        System.out.println(bookShop1);
    }

}
