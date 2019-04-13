package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;

import java.util.ArrayList;

public class SlidePagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private Book book =new Book();


    public SlidePagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return book.getPages().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_page, container, false);
        TextView txtDescription = view.findViewById(R.id.txt_DetailPage);
        txtDescription.setText(book.getPages().get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}

class Book {
    private String name;
    private ArrayList<String> pages ;

    public Book() {
        pages=new ArrayList<>();
        name="My Book";
        pages.add("Page 1");
        pages.add("Page 2");
        pages.add("Page 3");
        pages.add("Page 4");
        pages.add("Page 5");
    }

    public Book(String name, ArrayList<String> pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPages() {
        return pages;
    }
}