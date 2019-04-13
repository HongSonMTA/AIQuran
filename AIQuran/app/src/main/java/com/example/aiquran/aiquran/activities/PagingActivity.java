package com.example.aiquran.aiquran.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.SlidePagerAdapter;

public class PagingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlidePagerAdapter adapter;
    private TextView txtNumofPage;
    private ImageView imgPrev;
    private ImageView imgNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        initSidePage();
    }

    private void initSidePage() {
        viewPager = findViewById(R.id.view_page_paging);
        adapter = new SlidePagerAdapter(this);
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
}
