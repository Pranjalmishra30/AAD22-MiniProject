package com.example.androidproject;

public class BookModelClass {
    Integer id;
    String title;
    String author;
    String publisher;
    String price;

    public BookModelClass(){}
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
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
