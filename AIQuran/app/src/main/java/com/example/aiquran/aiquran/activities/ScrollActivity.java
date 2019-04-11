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

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.databinding.ActivityScrollingBinding;

public class ScrollActivity extends AppCompatActivity {
    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Scroll");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_scrolling);
//        SeekBar seekBar = findViewById(R.id.seek_bar);
        // final RecyclerView tmp  = findViewById(R.id.recycler_view);
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    // dựa vào progress để tính xem listview phải scroll tới đâu
//                    // ví dụ listview gồm 100 item
//                    // nếu progress là 50 thì tương ứng listview sẽ scroll tới item 50
//                    //tmp.scrollToPosition(); dùng hàm để scroll thôi
//                    //tmp.smoothScrollToPosition();// ok anh e hiểu rồi
//                    // để e thử luôn
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
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
}
