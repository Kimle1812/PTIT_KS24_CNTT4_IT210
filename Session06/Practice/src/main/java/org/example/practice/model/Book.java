package org.example.practice.model;

public class Book {
    private int bookId;
    private  String bookName;
    private String author;
    private double price;
    public Book() {
    }

    public Book(int bookId, String bookName, String author, Double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public int getId() {

        return bookId;
    }

    public void setId(int bookId) {
        this.bookId = bookId;
    }

    public String getNameBook() {
        return bookName;
    }

    public void setNameBook(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
