package com.example.aiquran.aiquran.models;

import java.io.Serializable;

public class BookMark implements Serializable {
    private String nameSurat;
    private int ayah;

    public BookMark(String nameSurat, int ayah) {
        this.nameSurat = nameSurat;
        this.ayah = ayah;
    }

    public String getNameSurat() {
        return nameSurat;
    }

    public void setNameSurat(String nameSurat) {
        this.nameSurat = nameSurat;
    }

    public int getAyah() {
        return ayah;
    }

    public void setAyah(int ayah) {
        this.ayah = ayah;
    }
}
