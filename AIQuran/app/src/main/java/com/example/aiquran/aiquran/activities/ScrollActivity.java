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
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.ColorAdapter;
import com.example.aiquran.aiquran.adapters.ScrollAdapter;
import com.example.aiquran.aiquran.databinding.ActivityScrollingBinding;
import com.example.aiquran.aiquran.models.Book;
import com.example.aiquran.aiquran.models.MyColor;

import java.util.ArrayList;

public class ScrollActivity extends AppCompatActivity implements ScrollAdapter.ItemViewActionCallBack {
    private ActivityScrollingBinding binding;
    private ScrollAdapter adapter;
    private Book book;
    private int overallXScrol = 0;

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
        adapter = new ScrollAdapter(this, book);
        binding.lvContentBook.setAdapter(adapter);
        adapter.setCallBack(this);
        binding.seekBar.setMax(book.getPages().size());
        binding.lvContentBook.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("newState", "newState->" + newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int rvHeight = recyclerView.getHeight();
                int offset = recyclerView.computeVerticalScrollOffset();
                int page = offset / rvHeight;
                Log.e("page", "page->" + page);
                binding.txtPage.setText(page + " Page ");
            }
        });
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.lvContentBook.scrollToPosition(progress);
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
        switch (item.getItemId()) {
            case R.id.add_book: {
                break;
            }
            case R.id.settings: {
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.next: {
                finish();
                break;
            }
            case R.id.previous: {
                break;
            }
            case R.id.turn_night: {
                break;
            }
            case R.id.turn_word: {
                break;
            }
            case R.id.translation: {
                Intent intent = new Intent(this, SettingTafsirTranslationActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.go_to: {
                dialogGoto();
                break;
            }
            case R.id.memorization: {
                dialogMemorization();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(int position, View view) {
        onClickText(position);
    }


    private void onClickText(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View mView = getLayoutInflater().inflate(R.layout.message_dialog, null);
        TextView txtMessage1 = mView.findViewById(R.id.txt_message1);
        TextView txtMessage2 = mView.findViewById(R.id.txt_message2);
        txtMessage1.setText(book.getPages().get(position).getDescribe());
        builder.setView(mView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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

    private void dialogMemorization() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Memorization Method");
        final View mView = getLayoutInflater().inflate(R.layout.popup_memorization, null);

        TextView firstStage = mView.findViewById(R.id.txt_FirstStage);
        TextView secondStage = mView.findViewById(R.id.txt_SecondStage);
        builder.setView(mView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
