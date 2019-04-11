package com.example.aiquran.aiquran.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.BookMarkAdapter;
import com.example.aiquran.aiquran.databinding.ActivityBookmarkBinding;
import com.example.aiquran.aiquran.models.BookMark;

import java.util.ArrayList;

public class BookMarkActivity extends AppCompatActivity implements BookMarkAdapter.ItemViewActionCallBack {
    private ActivityBookmarkBinding binding;
    private ArrayList<BookMark> arrBookMark;
    private BookMarkAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BookMarks");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bookmark);
        initView();
    }

    private void initView() {
        arrBookMark = new ArrayList<>();
        arrBookMark.add(new BookMark("Hello",1));
        arrBookMark.add(new BookMark("Hello",1));
        arrBookMark.add(new BookMark("Hello",2));
        arrBookMark.add(new BookMark("Hello",-1));
        arrBookMark.add(new BookMark("Hello",4));
        adapter = new BookMarkAdapter(this,arrBookMark);
        binding.lvBookMark.setAdapter(adapter);
        adapter.setCallBack(this);
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,ScrollActivity.class);
        startActivity(intent);
    }
}
