package com.example.aiquran.aiquran.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v7.preference.Preference;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.activities.ActivityDownloadAudio;

public class SettingTafsirTranslationFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_tafsir);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, android.preference.Preference preference) {
        switch (preference.getKey()){
            case "DownloadTafsir": {
                Intent intent = new Intent(getActivity(), ActivityDownloadAudio.class);
                startActivity(intent);
                return true;
            }
            default: return  false;
        }
    }
}
