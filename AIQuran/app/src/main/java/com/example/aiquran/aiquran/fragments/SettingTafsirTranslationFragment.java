package com.example.aiquran.aiquran.fragments;

import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;

import com.example.aiquran.aiquran.R;

public class SettingTafsirTranslationFragment extends PreferenceFragment {

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences_tafsir);
    }
}
