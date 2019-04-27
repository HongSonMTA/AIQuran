package com.example.aiquran.aiquran.models;

import java.util.ArrayList;

public class Page {
    private String content;
    private ArrayList<String> keyWords;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }

    public Page(String content, ArrayList<String> keyWords) {

        this.content = content;
        this.keyWords = keyWords;
    }
}
