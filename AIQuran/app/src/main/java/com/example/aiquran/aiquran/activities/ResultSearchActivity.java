package com.example.aiquran.aiquran.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
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
import com.example.aiquran.aiquran.data.DataManager;
import com.example.aiquran.aiquran.databinding.ActivityResultSearchBinding;
import com.example.aiquran.aiquran.models.BookMark;

import java.util.ArrayList;

public class ResultSearchActivity extends BaseActivity implements ResultSearchAdapter.ItemViewActionCallBack {
    private ActivityResultSearchBinding binding;
    private ArrayList<BookMark> arrBookMark;
    private ResultSearchAdapter adapter;
    private DataManager dataManager = new DataManager();
    private String key;
    private ProgressDialog progress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_result_search);

        initView();
    }
    private void initView() {

//        progress=new ProgressDialog(this);
//        progress.setMessage("Search");
//        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progress.show();

        Intent intent = getIntent();
        key = intent.getStringExtra("KeySearch");

        arrBookMark = dataManager.getBookMarks();
        adapter = new ResultSearchAdapter(this, arrBookMark, key);
        binding.lvResultSearch.setAdapter(adapter);
        adapter.setCallBack(this);
        // progress.dismiss();
    }


    @Override
    public void onClick(int position) {
        showAttention(position);
    }
    private void showAttention(final int position) {
        final View mView = getLayoutInflater().inflate(R.layout.checkbox, null);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Attention");
        mBuilder.setMessage("Choose the suitable method to explore the Holy Quran");
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("SCROLLING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ResultSearchActivity.this, ScrollActivity.class);
                intent.putExtra("ID_SURAS", position+1);
                intent.putExtra("SURAS_NAME",arrBookMark.get(position).getNameBook());
                startActivity(intent);
            }
        });
        mBuilder.setNegativeButton("PAGING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ResultSearchActivity.this, PagingActivity.class);
                intent.putExtra("ID_SURAS", position+1);
                intent.putExtra("SURAS_NAME",arrBookMark.get(position).getNameBook());
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }
}
