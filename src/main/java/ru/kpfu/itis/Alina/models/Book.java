package ru.kpfu.itis.Alina.models;

import java.io.Serializable;

/**
 * Created by Admin on 28.10.2016.
 */
public class Book implements Serializable {
    private String name;
    private int price;
    private String publisher;
    private String author;
    private String image;
    private long id;
    private int page;
    private int year;
    private String isbn;
    private int edition;
    private String language;
    private int weight;

    public Book() {
    }

    public Book(String name, long id, int price, String publisher, String author, String image, int page,
                int year, String isbn, int edition, String language, int weight) {
        this.price = price;
        this.publisher = publisher;
        this.name = name;
        this.id = id;
        this.author = author;
        this.image = image;
        this.page = page;
        this.year = year;
        this.isbn = isbn;
        this.edition = edition;
        this.language = language;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPages() {
        return page;
    }

    public void setPages(int page) {
        this.page = page;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}