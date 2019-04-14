package com.example.aiquran.aiquran.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.SlidePagerAdapter;
import com.example.aiquran.aiquran.models.Book;

import java.util.ArrayList;

public class PagingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlidePagerAdapter adapter;
    private TextView txtNumofPage;
    private ImageView imgPrev;
    private ImageView imgNext;
    private Book book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Paging");
        initSidePage();
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
                break;
            }
            case R.id.go_to: {
                dialogGoto();
                break;
            }
            case R.id.memorization: {
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBook() {
        book = new Book();
    }

    private void initSidePage() {
        initBook();
        viewPager = findViewById(R.id.view_page_paging);
        adapter = new SlidePagerAdapter(this, book);
        viewPager.setAdapter(adapter);
        imgPrev = findViewById(R.id.img_Previous);
        imgNext = findViewById(R.id.img_Next);
        txtNumofPage = findViewById(R.id.txt_numofpage);

        imgNext.setOnClickListener(onClick);
        imgPrev.setOnClickListener(onClick);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                txtNumofPage.setText(i + 1 + ":" + adapter.getCount());
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img_Previous:
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    txtNumofPage.setText(viewPager.getCurrentItem() + 1 + ":" + adapter.getCount());
                    break;
                case R.id.img_Next:
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    txtNumofPage.setText(viewPager.getCurrentItem() + 1 + ":" + adapter.getCount());
                    break;
            }
        }
    };

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
                    viewPager.setCurrentItem(Integer.parseInt(input.getText().toString()) - 1);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
