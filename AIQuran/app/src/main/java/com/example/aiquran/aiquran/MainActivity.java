package com.example.aiquran.aiquran;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aiquran.aiquran.activities.BookMarkActivity;
import com.example.aiquran.aiquran.activities.ScrollActivity;
import com.example.aiquran.aiquran.activities.SearchActivity;
import com.example.aiquran.aiquran.adapters.MyAdapter;
import com.example.aiquran.aiquran.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private MyAdapter myAdapter;
    private ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initView();
    }

    private void initView() {
        myAdapter = new MyAdapter(getSupportFragmentManager());
        binding.viewPage.setAdapter(myAdapter);
        binding.viewPage.addOnPageChangeListener(this);
        binding.tablayout.setupWithViewPager(binding.viewPage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_more,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:{
                break;
            }
            case R.id.search:{
                Intent intent = new Intent(this,SearchActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.help:{
                break;
            }
            case R.id.about:{
                break;
            }
            case R.id.share:{
                break;
            }
            case R.id.reading_position:{
                Intent intent = new Intent(this,ScrollActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.rate:{
                break;
            }
            case R.id.bookmarks: {
                Intent intent = new Intent(this,BookMarkActivity.class);
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
}
