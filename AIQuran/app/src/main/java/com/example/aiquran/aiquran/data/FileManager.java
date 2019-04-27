package com.example.aiquran.aiquran.data;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
    private Context mContext;

    public FileManager(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<String> getQuranSuraContents(int id) {

        ArrayList<String> pages = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("books/");
        stringBuilder.append(id);
        stringBuilder.append(".txt");
        String fileName = stringBuilder.toString();
        BufferedReader reader;

        try {
            final InputStream file = mContext.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            pages.add(line);
            while (line != null) {
                line = reader.readLine();

                if(line!=null)
                {
                    line=line.trim();
                    pages.add(line);
                }

                Log.d("StackOverflow", "" + line);

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return pages;
    }

    public ArrayList<String> getKeyWordsPage(int page, int idBook){
        ArrayList<String > keyWords = new ArrayList<>();
        return keyWords;
    }
}
