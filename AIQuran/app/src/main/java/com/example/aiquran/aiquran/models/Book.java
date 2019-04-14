package com.example.aiquran.aiquran.models;

import java.util.ArrayList;

public class Book {
    private String name;
    private ArrayList<ContentBook> pages ;

    public Book() {
        this.name = "Name Book";
        pages = new ArrayList<>();
        pages.add(new ContentBook(1,"The Most Popular Quran Application that introduce all Islamic religion text with high smart book and local search engine, over than 10.000.000 users,\n" +
                "When you open first time the application contain index of the Qur'an (Holy Islamic text), in addition to smart access that enables access to the settings, research, and “my favorites”, \n" +
                "When you tab at any Surah, the application will ask for the first time about the style of reading you prefer according to your convenience,\n" +
                "When you tab the red shaded words, word meaning in the Koran appear to understanding and reading the Quran at once.",
                "The full text of the Qur'an provides memorization feature with two levels",
                "The 1st for Ayahat (verses) and 2nd for words with hearing the Ayahat (verses) to know the correct pronunciation of the Koran.\n" +
                "Sometimes we find it difficult to search for a specific word Koran, Al-Quran (free) provides a local search in addition to instant access to the selected result."));
        pages.add(new ContentBook(2,"The Most Popular Quran Application that introduce all Islamic religion text with high smart book and local search engine, over than 10.000.000 users,\n" +
                "When you open first time the application contain index of the Qur'an (Holy Islamic text), in addition to smart access that enables access to the settings, research, and “my favorites”, \n" +
                "When you tab at any Surah, the application will ask for the first time about the style of reading you prefer according to your convenience,\n" +
                "When you tab the red shaded words, word meaning in the Koran appear to understanding and reading the Quran at once.",
                "The full text of the Qur'an provides memorization feature with two levels",
                "The 1st for Ayahat (verses) and 2nd for words with hearing the Ayahat (verses) to know the correct pronunciation of the Koran.\n" +
                "Sometimes we find it difficult to search for a specific word Koran, Al-Quran (free) provides a local search in addition to instant access to the selected result."));
        pages.add(new ContentBook(3,"The Most Popular Quran Application that introduce all Islamic religion text with high smart book and local search engine, over than 10.000.000 users,\n" +
                "When you open first time the application contain index of the Qur'an (Holy Islamic text), in addition to smart access that enables access to the settings, research, and “my favorites”, \n" +
                "When you tab at any Surah, the application will ask for the first time about the style of reading you prefer according to your convenience,\n" +
                "When you tab the red shaded words, word meaning in the Koran appear to understanding and reading the Quran at once.","The full text of the Qur'an provides memorization feature with two levels","The 1st for Ayahat (verses) and 2nd for words with hearing the Ayahat (verses) to know the correct pronunciation of the Koran.\n" +
                "Sometimes we find it difficult to search for a specific word Koran, Al-Quran (free) provides a local search in addition to instant access to the selected result."));
        pages.add(new ContentBook(4,"The Most Popular Quran Application that introduce all Islamic religion text with high smart book and local search engine, over than 10.000.000 users,\n" +
                "When you open first time the application contain index of the Qur'an (Holy Islamic text), in addition to smart access that enables access to the settings, research, and “my favorites”, \n" +
                "When you tab at any Surah, the application will ask for the first time about the style of reading you prefer according to your convenience,\n" +
                "When you tab the red shaded words, word meaning in the Koran appear to understanding and reading the Quran at once.",
                "The full text of the Qur'an provides memorization feature with two levels","The 1st for Ayahat (verses) and 2nd for words with hearing the Ayahat (verses) to know the correct pronunciation of the Koran.\n" +
                "Sometimes we find it difficult to search for a specific word Koran, Al-Quran (free) provides a local search in addition to instant access to the selected result."));
        pages.add(new ContentBook(5,"The Most Popular Quran Application that introduce all Islamic religion text with high smart book and local search engine, over than 10.000.000 users,\n" +
                "When you open first time the application contain index of the Qur'an (Holy Islamic text), in addition to smart access that enables access to the settings, research, and “my favorites”, \n" +
                "When you tab at any Surah, the application will ask for the first time about the style of reading you prefer according to your convenience,\n" +
                "When you tab the red shaded words, word meaning in the Koran appear to understanding and reading the Quran at once.",
                "The full text of the Qur'an provides memorization feature with two levels",
                "The 1st for Ayahat (verses) and 2nd for words with hearing the Ayahat (verses) to know the correct pronunciation of the Koran.\n" +
                "Sometimes we find it difficult to search for a specific word Koran, Al-Quran (free) provides a local search in addition to instant access to the selected result."));
    }
//    public Book(String name, ArrayList<ContentBook> pages) {
//        this.name = name;
//        this.pages = pages;
//    }

    public String getName() {
        return name;
    }

    public ArrayList<ContentBook> getPages() {
        return pages;
    }
}
