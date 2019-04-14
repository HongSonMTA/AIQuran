package com.example.aiquran.aiquran.models;

import java.util.ArrayList;

public class Book {
    private String name;
    private ArrayList<String> pages ;

    public Book() {

    }

    public Book(String name, ArrayList<String> pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPages() {
        return pages;
    }
}
