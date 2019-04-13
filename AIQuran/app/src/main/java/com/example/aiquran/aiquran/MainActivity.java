package com.example.aiquran.aiquran;

import android.app.Dialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.aiquran.aiquran.activities.BookMarkActivity;
import com.example.aiquran.aiquran.activities.ScrollActivity;
import com.example.aiquran.aiquran.activities.SearchActivity;
import com.example.aiquran.aiquran.adapters.MyAdapter;
import com.example.aiquran.aiquran.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private MyAdapter myAdapter;
    private ActivityMainBinding binding;
    private Dialog dialogAbout;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        myAdapter = new MyAdapter(getSupportFragmentManager());
        binding.viewPage.setAdapter(myAdapter);
        binding.viewPage.addOnPageChangeListener(this);
        binding.tablayout.setupWithViewPager(binding.viewPage);
       createBottomSheet();
        //createBottomSheetBehavior();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_more, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: {
                break;
            }
            case R.id.search: {
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.help: {
                break;
            }
            case R.id.about: {
                showAbout();
                break;
            }
            case R.id.share: {
                bottomSheetDialog.show();
              //  mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            }
            case R.id.reading_position: {
                Intent intent = new Intent(this, ScrollActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.rate: {
                break;
            }
            case R.id.bookmarks: {
                Intent intent = new Intent(this, BookMarkActivity.class);
                startActivity(intent);
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private void showAbout() {
        TextView txtCloseAbout;
        dialogAbout = new Dialog(this);
        dialogAbout.setContentView(R.layout.activity_about);
        txtCloseAbout = dialogAbout.findViewById(R.id.txt_closeAbout);
        txtCloseAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogAbout.dismiss();
            }
        });
        dialogAbout.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogAbout.show();
    }

    private void createBottomSheet() {
        if (bottomSheetDialog == null) {
            View bottomSheet = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_share, null);
            bottomSheetDialog = new BottomSheetDialog(this);
            bottomSheetDialog.setContentView(bottomSheet);
        }
    }
}
