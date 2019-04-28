package com.example.aiquran.aiquran.data;

import com.example.aiquran.aiquran.models.BookMark;
import com.example.aiquran.aiquran.models.Suras;
import com.example.aiquran.aiquran.models.SurasNames;

import java.util.ArrayList;

public class DataManager {

    private SurasNames surasNames = new SurasNames();
    private ArrayList<Suras> suras;
    private ArrayList<BookMark> bookMarks;
    private ArrayList<String> listSurat;

    public DataManager() {
        suras = new ArrayList<>();
        bookMarks = new ArrayList<>();
        for (int i = 0; i < 114; i++) {
            suras.add(new Suras(i + 1 + "", surasNames.getSuraNameEn(i), surasNames.getSurasNameAr(i)));
            bookMarks.add(new BookMark(i+1,surasNames.getSuraNameEn(i),surasNames.getSurasNameAr(i),i+1));
            //listSurat.add(surasNames.getSurasNameAr(i));
        }

    }

    public ArrayList<Suras> getSuras() {
        return suras;
    }

    public ArrayList<BookMark> getBookMarks() {
        return bookMarks;
    }

    public ArrayList<String> getListSurat() {
        return listSurat;
    }
}
