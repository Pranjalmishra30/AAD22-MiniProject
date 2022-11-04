package com.example.androidproject;

public class BookModelClass {
    static Integer id;
    static String title;
    static String author;
    static String publisher;
    static String price;

    public BookModelClass(Integer id,String title, String author, String publisher, String price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    public BookModelClass(String title, String author, String publisher, String price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
