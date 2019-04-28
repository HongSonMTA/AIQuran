package com.example.aiquran.aiquran.data;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FileManager {
    private Context mContext;
    private static final String mFileBookMark = "bookmark.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aiquran/" + mFileBookMark;

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

                if (line != null) {
                    line = line.trim();
                    pages.add(line);
                }

                Log.d("StackOverflow", "" + line);

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return pages;
    }

    public ArrayList<String> getKeyWordsPage(int page, int idBook) {
        ArrayList<String> keyWords = new ArrayList<>();
        return keyWords;
    }


    public String loadBookmark() {
        String line = null;

        if (isExternalStorageReadable()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(path));
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                fileInputStream.close();
                line = stringBuilder.toString();

                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                Log.d("FileManager", ex.getMessage());
            } catch (IOException ex) {
                Log.d("FileManager", ex.getMessage());
            }
        } else {
            Toast.makeText(mContext, "isExternalStorageReadable : false", Toast.LENGTH_LONG).show();
        }
        if (line == null)
            line = "null";
        return line;
    }


    public void saveFile(String data) {
        String state;
        state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File root = Environment.getExternalStorageDirectory();

            File dir = new File(root.getAbsolutePath() + "/aiquran");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file1 = new File(dir, mFileBookMark);
            try {
                FileOutputStream outputStream = new FileOutputStream(file1);
                outputStream.write(data.getBytes());
                // outputStream.
                outputStream.close();
                //  Toast.makeText(mContext, "1", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(mContext, "SD not found!", Toast.LENGTH_LONG).show();
        }
    }


    public boolean isOnBookmark(int idBook) {

        String bookmarks = loadBookmark();
        if (bookmarks.indexOf(idBook + ",") != -1) {
            return  true;
        }

        return false;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
