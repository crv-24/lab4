package com.example.databasemusic;

public class Music {
    private int id;
    private String name;
    private String author;
    private int year;
    private String album;
    private String country;

    public Music() {}

    public Music(int id, String name, String author, int year, String album, String country) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.album = album;
        this.country = country;
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public int getyear() {
        return year;
    }

    public void setyear(int year) {
        this.year = year;
    }

    public String getalbum() {
        return album;
    }

    public void setalbum(String album) {
        this.album = album;
    }

    public String getcountry() {
        return country;
    }

    public void setcountry(String country) {
        this.country = country;
    }
}
