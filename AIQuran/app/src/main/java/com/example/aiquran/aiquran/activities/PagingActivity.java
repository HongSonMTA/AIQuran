package com.example.aiquran.aiquran.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.SlidePagerAdapter;
import com.example.aiquran.aiquran.base.BaseActivity;
import com.example.aiquran.aiquran.data.FileManager;
import com.example.aiquran.aiquran.models.Book;

import java.util.ArrayList;

public class PagingActivity extends BaseActivity implements SlidePagerAdapter.ItemViewCallBack {

    private ViewPager viewPager;
    private SlidePagerAdapter adapter;
    private RelativeLayout bottomPaging;
    private TextView tvNameOfBook;
    private TextView txtNumofPage;
    private ImageView imgPrev;
    private ImageView imgNext;
    private Book book;

    private String currentPage= "1";
    private FileManager fileManager = new FileManager(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Paging");
        initSidePage();
    }


    private void initBook() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int idBook = bundle.getInt("ID_SURAS");
        Log.i("ID_SURAS ", idBook + "");
        String nameOfBook = bundle.getString("SURAS_NAME");
        Log.i("SURAS_NAME ", nameOfBook);
        ArrayList<String> pages = fileManager.getQuranSuraContents(idBook);
        book = new Book(nameOfBook, pages);
    }

    private void initSidePage() {
        initBook();
        viewPager = findViewById(R.id.view_page_paging);
        adapter = new SlidePagerAdapter(this, book);
        adapter.setCallBack(this);
        viewPager.setAdapter(adapter);
        bottomPaging = findViewById(R.id.relativeBottomPaging);
        bottomPaging.setBackgroundColor(getResources().getColor(getIdBackgroundTab()));
        imgPrev = findViewById(R.id.img_Previous);
        imgNext = findViewById(R.id.img_Next);
        txtNumofPage = findViewById(R.id.txt_numofpage);
        tvNameOfBook = findViewById(R.id.tvNameOfBookPaging);

        imgNext.setOnClickListener(onClick);
        imgPrev.setOnClickListener(onClick);

        tvNameOfBook.setText(book.getName());
        int pages = book.getPagesString().size();
        txtNumofPage.setText(currentPage+":"+Integer.toString(pages));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                // String page = i+1+":"+adapter.getCount();
                currentPage = i+1+":"+adapter.getCount();
                txtNumofPage.setText(currentPage);

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

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




    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.img_Previous:
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    break;
                case R.id.img_Next:
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    break;
            }
            currentPage = viewPager.getCurrentItem() + 1 + ":" + adapter.getCount();
            txtNumofPage.setText(currentPage);
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

    @Override
    public void onClick(int position) {
        onClickText(position);
    }

    private void onClickText(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View mView = getLayoutInflater().inflate(R.layout.message_dialog, null);
        TextView txtMessage1 = mView.findViewById(R.id.txt_message1);
        TextView txtMessage2 = mView.findViewById(R.id.txt_message2);
        //txtMessage1.setText(book.getPages().get(position).getDescribe());
        builder.setView(mView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
