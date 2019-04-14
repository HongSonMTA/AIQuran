package com.example.aiquran.aiquran.models;

public class ContentBook {
    private  int id ;
    private String contentOne;
    private String describe;
    private String contentTwo;

    public ContentBook(int id, String contentOne, String describe, String contentTwo) {
        this.id = id;
        this.contentOne = contentOne;
        this.describe = describe;
        this.contentTwo = contentTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentOne() {
        return contentOne;
    }

    public void setContentOne(String contentOne) {
        this.contentOne = contentOne;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getContentTwo() {
        return contentTwo;
    }

    public void setContentTwo(String contentTwo) {
        this.contentTwo = contentTwo;
    }
}
