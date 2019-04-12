package com.example.aiquran.aiquran.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.databinding.ActivityResultSearchBinding;

public class ResultSearchActivity extends AppCompatActivity {
    private ActivityResultSearchBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_result_search);
    }
}
