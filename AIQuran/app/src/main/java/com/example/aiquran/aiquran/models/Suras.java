package com.example.aiquran.aiquran.models;

import java.io.Serializable;

public class Suras implements Serializable {
    private String id;
    private String originalWords;
    private  String translationWords;
    private boolean isDownloadSelected;



    public Suras(String id, String originalWords, String translationWords) {
        this.id = id;
        this.originalWords = originalWords;
        this.translationWords = translationWords;
        this.isDownloadSelected=false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalWords() {
        return originalWords;
    }

    public void setOriginalWords(String originalWords) {
        this.originalWords = originalWords;
    }

    public String getTranslationWords() {
        return translationWords;
    }

    public void setTranslationWords(String translationWords) {
        this.translationWords = translationWords;
    }
    public boolean isDownloadSelected() {
        return isDownloadSelected;
    }

    public void setDownloadSelected(boolean downloadSelected) {
        isDownloadSelected = downloadSelected;
    }
}
