package com.example.aiquran.aiquran.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.ScrollAdapter;
import com.example.aiquran.aiquran.databinding.ActivityScrollingBinding;
import com.example.aiquran.aiquran.models.Book;

public class ScrollActivity extends AppCompatActivity implements ScrollAdapter.ItemViewActionCallBack {
    private ActivityScrollingBinding binding;
    private ScrollAdapter adapter;
    private Book book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Scroll");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);
        initView();
    }

    private void initView() {
        book = new Book();
        adapter = new ScrollAdapter(this,book);
        binding.lvContentBook.setAdapter(adapter);
        adapter.setCallBack(this);
        // binding.lvContentBook.scrollToPosition(3);
        binding.seekBar.setMax(book.getPages().size());
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.lvContentBook.scrollToPosition(progress);
                // binding.lvContentBook.smoothScrollToPosition(progress);
                // Toast.makeText(ScrollActivity.this,"123123",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scroll_page, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_book:{
                break;
            }
            case R.id.settings:{
                break;
            }
            case R.id.next:{
                finish();
                break;
            }
            case R.id.previous:{

                break;
            }
            case R.id.turn_night:{
                break;
            }
            case R.id.turn_word:{
                break;
            }
            case R.id.translation:{
                break;
            }
            case R.id.go_to:{
                break;
            }
            case R.id.memorization:{
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int position) {

    }
}
