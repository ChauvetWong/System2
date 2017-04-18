package com.example.system2.entity;

/**
 * Created by luoxiongwen on 16/10/24.
 */

public class Movie {

    public String name;
    public int length;
    public int price;
    public String content;

    public Movie(String name, int length, int price,String content) {
        this.length = length;
        this.name = name;
        this.price = price;
        this.content=content;
    }

    public int getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }
}
