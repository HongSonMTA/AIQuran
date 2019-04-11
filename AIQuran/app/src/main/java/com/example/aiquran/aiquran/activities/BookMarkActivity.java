package com.example.aiquran.aiquran.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.databinding.ActivityBookmarkBinding;

public class BookMarkActivity extends AppCompatActivity {
    private ActivityBookmarkBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BookMarks");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bookmark);
    }
}
