package com.example.aiquran.aiquran.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.fragments.SettingFragement;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Setting");
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingFragement())
                .commit();
    }
}
