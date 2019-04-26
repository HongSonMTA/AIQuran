package com.example.aiquran.aiquran.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.base.BaseActivity;
import com.example.aiquran.aiquran.fragments.SettingFragment;
import com.example.aiquran.aiquran.models.Theme;
import com.example.aiquran.aiquran.util.ThemeUtil;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment.ColorPickerDialogListener;

import java.util.ArrayList;


public class SettingActivity extends BaseActivity implements ColorPickerDialogListener {

	private static final int DIALOG_ID = 0;
	private static final int PREFERENCE_DIALOG_FONT_COLOR = 1;
	private static final int PREFERENCE_DIALOG_TEXT_COLOR = 2;

	private SettingFragment mPreferenceFragment;
	SharedPreferences sharedPref;
	int idCurrentTheme;
	private ArrayList<Theme> arrTheme = ThemeUtil.getThemeList();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_setting);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Setting");
		sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		idCurrentTheme = sharedPref.getInt(KEY_CURRENT_THEME, R.style.AppTheme_RED);
		setTheme(idCurrentTheme);

		initView();
	}

	private void initView() {
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingFragment())
				.commit();
		mPreferenceFragment = new SettingFragment();
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, mPreferenceFragment).commit();
	}

	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("SettingFragment");
	}

	@Override
	public void onColorSelected(int dialogId, int color) {
		switch(dialogId) {
		case PREFERENCE_DIALOG_FONT_COLOR:

				((ColorPickerDialogListener)mPreferenceFragment)
						.onColorSelected(dialogId, color);

				break;
		case PREFERENCE_DIALOG_TEXT_COLOR:

			((ColorPickerDialogListener)mPreferenceFragment)
					.onColorSelected(dialogId, color);

			break;
		case DIALOG_ID:

			Toast.makeText(SettingActivity.this, "Selected MyColor: " + colorToHexString(color), Toast.LENGTH_SHORT).show();
			break;
		}

	}

	public void setAppTheme (int position){
        if(idCurrentTheme != arrTheme.get(position).getId()) {
            idCurrentTheme= arrTheme.get(position).getId();

            SharedPreferences.Editor spedit = sharedPref.edit();
            spedit.putInt(KEY_CURRENT_THEME, idCurrentTheme);
            spedit.putInt("ID_BG_TABBAR",position);
            spedit.apply();

            recreate();
        }
    }

	@Override
	public void onDialogDismissed(int dialogId) {

		switch(dialogId) {
		case PREFERENCE_DIALOG_TEXT_COLOR:
			((ColorPickerDialogListener)mPreferenceFragment)
			.onDialogDismissed(dialogId);

			break;
		case PREFERENCE_DIALOG_FONT_COLOR:
			((ColorPickerDialogListener)mPreferenceFragment)
					.onDialogDismissed(dialogId);
			break;
		}
	}

	private static String colorToHexString(int color) {
		return String.format("#%06X", 0xFFFFFFFF & color);
	}

}
 