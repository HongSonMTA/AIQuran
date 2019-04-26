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
        int numberOfLine = 0;
        ArrayList<String> pages = new ArrayList<>();
        String fileName = id + ".txt";
        BufferedReader reader;

        try {
            final InputStream file = mContext.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            numberOfLine++;
            while (line != null) {
                line = reader.readLine();
                pages.add(line);
                Log.d("StackOverflow", ""+line);

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return pages;
    }
}
