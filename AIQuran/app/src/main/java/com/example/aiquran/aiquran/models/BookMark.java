package com.example.aiquran.aiquran.models;

import java.io.Serializable;
import java.util.ArrayList;

public class BookMark implements Serializable {
    private String nameBook;
    private String nameSurat;
    private int ayah;
    private String nameAll;
    private int id;


    public BookMark(int id, String nameBook, String nameSurat, int ayah) {
        this.nameBook = nameBook;
        this.nameSurat = nameSurat;
        this.ayah = ayah;
        this.id = id;
    }

    public BookMark(String nameBook, String nameSurat, int ayah) {
        this.nameBook = nameBook;
        this.nameSurat = nameSurat;
        this.ayah = ayah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
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

    public String getNameAll() {
        return nameBook + "("+ ayah+")" + nameSurat;
    }

    public void setNameAll(String nameAll) {
        this.nameAll = nameAll;
    }

}
