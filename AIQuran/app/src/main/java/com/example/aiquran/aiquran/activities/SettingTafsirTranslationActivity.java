package com.example.aiquran.aiquran.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.base.BaseActivity;
import com.example.aiquran.aiquran.fragments.SettingTafsirTranslationFragment;

public class SettingTafsirTranslationActivity extends BaseActivity {
    private SettingTafsirTranslationFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_tafsir);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Setting");

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingTafsirTranslationFragment())
                .commit();

        fragment = new SettingTafsirTranslationFragment();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();
    }
}
