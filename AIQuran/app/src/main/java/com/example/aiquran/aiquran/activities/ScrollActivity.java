package com.example.aiquran.aiquran.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
    private int  overallXScrol = 0;

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
        binding.lvContentBook.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("newState","newState->" + newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                overallXScrol = overallXScrol + dy;

                Log.e("check","overall->" + overallXScrol);
            }
        });
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.lvContentBook.scrollToPosition(progress);
               //  binding.lvContentBook.
//                binding.txtPage.setText()
                // binding.lvContentBook.get
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
                Intent intent = new Intent(this,SettingActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(this,SettingTafsirTranslationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.go_to:{
                dialogGoto();
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

    private void dialogGoto() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Go to Ayah");
        final View mView = getLayoutInflater().inflate(R.layout.input_page_number, null);

        final EditText input = mView.findViewById(R.id.edt_input_page);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(mView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                binding.lvContentBook.scrollToPosition(Integer.parseInt(input.getText().toString()) - 1);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
