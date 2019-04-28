package com.example.aiquran.aiquran.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.BookMarkAdapter;
import com.example.aiquran.aiquran.base.BaseActivity;
import com.example.aiquran.aiquran.data.DataManager;
import com.example.aiquran.aiquran.data.FileManager;
import com.example.aiquran.aiquran.databinding.ActivityBookmarkBinding;
import com.example.aiquran.aiquran.models.BookMark;

import java.util.ArrayList;

public class BookMarkActivity extends BaseActivity implements BookMarkAdapter.ItemViewActionCallBack {
    private ActivityBookmarkBinding binding;
    private DataManager dataManager = new DataManager();
    private ArrayList<BookMark> arrBookMark;
    private BookMarkAdapter adapter;
    private FileManager fileManager = new FileManager(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("BookMarks");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bookmark);
        initView();
    }

    private void getBookmarkSaved() {
        arrBookMark = new ArrayList<>();
        String saved = fileManager.loadBookmark();
        if (saved != null) {
            String[] list = saved.split(",");
            for (int i = 0; i < list.length; i++) {
                Log.i("Bookmark saved : " + i + " : ", list[i]);
                int index = Integer.parseInt(list[i]);
                for (int j = 0; j < dataManager.getBookMarks().size(); j++) {
                    if ((index) == dataManager.getBookMarks().get(j).getId()) {
                        arrBookMark.add(dataManager.getBookMarks().get(j));
                    }
                }
            }
        }
    }

    private void initView() {

        getBookmarkSaved();
        adapter = new BookMarkAdapter(this, arrBookMark);
        binding.lvBookMark.setAdapter(adapter);
        adapter.setCallBack(this);
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
        final Intent[] intent = new Intent[1];
        intent[0] = new Intent(BookMarkActivity.this, ScrollActivity.class);

        mBuilder.setPositiveButton("SCROLLING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                intent[0] = new Intent(BookMarkActivity.this, ScrollActivity.class);
                intent[0].putExtra("ID_SURAS", arrBookMark.get(position).getId());
                intent[0].putExtra("SURAS_NAME", arrBookMark.get(position).getNameSurat());
                startActivity(intent[0]);
            }
        });
        mBuilder.setNegativeButton("PAGING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                intent[0] = new Intent(BookMarkActivity.this, PagingActivity.class);
                intent[0].putExtra("ID_SURAS", arrBookMark.get(position).getId());
                intent[0].putExtra("SURAS_NAME", arrBookMark.get(position).getNameSurat());
                startActivity(intent[0]);
            }
        });


        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
    }
}
