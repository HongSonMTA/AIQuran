package com.example.aiquran.aiquran.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.ResultSearchAdapter;
import com.example.aiquran.aiquran.base.BaseActivity;
import com.example.aiquran.aiquran.databinding.ActivityResultSearchBinding;
import com.example.aiquran.aiquran.models.BookMark;

import java.util.ArrayList;

public class ResultSearchActivity extends BaseActivity implements ResultSearchAdapter.ItemViewActionCallBack {
    private ActivityResultSearchBinding binding;
    private ArrayList<BookMark> arrBookMark;
    private ResultSearchAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_result_search);
        initView();
    }
    private void initView() {
        arrBookMark = new ArrayList<>();
        arrBookMark.add(new BookMark("Hello(144)","Hello", 144));
        arrBookMark.add(new BookMark("Hello(133)","Hello", 133));
        arrBookMark.add(new BookMark("Hello(244)","Hello", 244));
        arrBookMark.add(new BookMark("Hello(133)","Hello", 133));
        arrBookMark.add(new BookMark("Hello(122)","Hello", 122));
        adapter = new ResultSearchAdapter(this, arrBookMark);
        binding.lvResultSearch.setAdapter(adapter);
        adapter.setCallBack(this);
    }

    @Override
    public void onClick(int position) {
        showAttention(position);
    }
    private void showAttention(int position) {
        final View mView = getLayoutInflater().inflate(R.layout.checkbox, null);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Attention");
        mBuilder.setMessage("Choose the suitable method to explore the Holy Quran");
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("SCROLLING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ResultSearchActivity.this, ScrollActivity.class);
                startActivity(intent);
            }
        });
        mBuilder.setNegativeButton("PAGING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ResultSearchActivity.this, PagingActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }
}
