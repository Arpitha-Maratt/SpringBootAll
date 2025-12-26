package com.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable {
    private String shopName;
    List<Book> booList = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooList() {
        return booList;
    }

    public void setBooList(List<Book> booList) {
        this.booList = booList;
    }

    public void loadData()
    {
        for(int i=1;i<=10;i++){
            Book book= new Book();
            book.setBookId(i);
            book.setBookName("Book" + i);
            getBooList().add(book);
        }

    }
    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", booList=" + booList +
                '}';
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop bookShop = new BookShop();
        for(Book book : this.getBooList()){
            bookShop.getBooList().add(book);
        }
        return bookShop;
//        return super.clone();
    }
}
