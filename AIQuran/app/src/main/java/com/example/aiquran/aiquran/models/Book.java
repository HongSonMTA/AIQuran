package com.example.aiquran.aiquran.models;

import java.util.ArrayList;

public class Book {
    private int id;
    private String name;
    //private ArrayList<ContentBook> pages;
    private ArrayList<String> pagesString;
    private ArrayList<Page> pages;




    public Book(String name, ArrayList<Page> pages) {
        this.name = name;
        this.pages = pages;
    }

    public Book(int id,String name, ArrayList<String> pages) {
        this.id=id;
        this.name = name;
        this.pagesString = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPagesString(ArrayList<String> pagesString) {
        this.pagesString = pagesString;
    }

    public ArrayList<String> getPagesString() {
        return pagesString;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
    }


}
