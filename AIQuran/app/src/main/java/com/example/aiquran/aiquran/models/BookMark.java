package com.example.aiquran.aiquran.models;

import java.io.Serializable;
import java.util.ArrayList;

public class BookMark implements Serializable {
    private String nameBook;
    private String nameSurat;
    private int ayah;

    public BookMark(String nameBook,String nameSurat, int ayah) {
        this.nameBook = nameBook;
        this.nameSurat = nameSurat;
        this.ayah = ayah;
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
    public ArrayList<BookMark> getBookMarkList(){
        ArrayList<BookMark> arrBookMark = new ArrayList<>();
        arrBookMark.add(new BookMark("Hello(144)","Hello", 144));
        arrBookMark.add(new BookMark("Hello(133)","Hello", 133));
        arrBookMark.add(new BookMark("Hello(244)","Hello", 244));
        arrBookMark.add(new BookMark("Hello(133)","Hello", 133));
        arrBookMark.add(new BookMark("Hello(122)","Hello", 122));
        return arrBookMark;
    }
}
