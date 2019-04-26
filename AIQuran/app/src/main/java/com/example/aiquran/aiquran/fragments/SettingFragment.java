package com.example.aiquran.aiquran.fragments;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.activities.ActivityDownloadAudio;
import com.example.aiquran.aiquran.activities.SettingActivity;
import com.example.aiquran.aiquran.adapters.ColorAdapter;
import com.example.aiquran.aiquran.models.Theme;
import com.example.aiquran.aiquran.util.ThemeUtil;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment;
import com.github.danielnilsson9.colorpickerview.preference.ColorPreference;

import java.util.ArrayList;

public class SettingFragment extends PreferenceFragment implements
        ColorPickerDialogFragment.ColorPickerDialogListener {

    private static final int PREFERENCE_DIALOG_FONT_COLOR = 1;
    private static final int PREFERENCE_DIALOG_TEXT_COLOR = 2;
    private  SharedPreferences sharedPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

        addPreferencesFromResource(R.xml.preferences);
        ColorPreference FontColor = (ColorPreference) findPreference("FontColor");
        FontColor.setOnShowDialogListener(new ColorPreference.OnShowDialogListener() {

            @Override
            public void onShowColorPickerDialog(String title, int currentColor) {

                ColorPickerDialogFragment dialog = ColorPickerDialogFragment
                        .newInstance(PREFERENCE_DIALOG_FONT_COLOR, "Font MyColor", null, currentColor, false);

                dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.LightPickerDialogTheme);
                dialog.show(getFragmentManager(), "pre_dialog");
            }
        });
        ColorPreference TextStrokeColor = (ColorPreference) findPreference("TextStrokeColor");
        TextStrokeColor.setOnShowDialogListener(new ColorPreference.OnShowDialogListener() {

            @Override
            public void onShowColorPickerDialog(String title, int currentColor) {

                ColorPickerDialogFragment dialog = ColorPickerDialogFragment
                        .newInstance(PREFERENCE_DIALOG_TEXT_COLOR, "Text Stroke MyColor", null, currentColor, false);

                dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.LightPickerDialogTheme);
                dialog.show(getFragmentManager(), "pre_dialog");
            }
        });
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (dialogId) {
            case PREFERENCE_DIALOG_FONT_COLOR:
                ColorPreference FontColor = (ColorPreference) findPreference("FontColor");
                FontColor.saveValue(color);
                break;
            case PREFERENCE_DIALOG_TEXT_COLOR:
                ColorPreference TextStrokeColor = (ColorPreference) findPreference("TextStrokeColor");
                TextStrokeColor.saveValue(color);
                break;
        }
    }

    @Override
    public void onDialogDismissed(int dialogId) {
        // Nothing to do.
    }
    @SuppressLint("NewApi")
    private void dialogSelectColor() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Theme");
        View view = getLayoutInflater().inflate(R.layout.list_color, null);
        RecyclerView rcv_listColor = view.findViewById(R.id.rcv_list_color);
        ArrayList<Theme> arrThem = ThemeUtil.getThemeList();
        ColorAdapter colorAdapter = new ColorAdapter(arrThem, builder.getContext());
        rcv_listColor.setAdapter(colorAdapter);

        builder.setView(view);
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();
        colorAdapter.setColorCallBack(new ColorAdapter.ItemColorCallBack() {
            @Override
            public void onselectColor(int position) {
                SettingActivity settingActivity = (SettingActivity) getActivity();
                settingActivity.setAppTheme(position);
                dialog.dismiss();
            }
        });
    }

        @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, android.preference.Preference preference) {
        switch (preference.getKey()) {
            case "ChooseThems": {
                dialogSelectColor();
                return true;
            }
            case "DownloadAudio": {
                Intent intent = new Intent(getActivity(), ActivityDownloadAudio.class);
                intent.putExtra("Key", 1);
                startActivity(intent);
                return true;
            }
            case "DownloadTafsir": {
                Intent intent = new Intent(getActivity(), ActivityDownloadAudio.class);
                intent.putExtra("Key", 2);
                startActivity(intent);
                return true;
            }
            default:
                return false;
        }
    }
}
