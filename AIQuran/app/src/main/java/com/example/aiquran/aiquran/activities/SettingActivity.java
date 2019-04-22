package com.example.aiquran.aiquran.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.fragments.SettingFragment;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment.ColorPickerDialogListener;

public class SettingActivity extends AppCompatActivity implements ColorPickerDialogListener {

	private static final int DIALOG_ID = 0;
	private static final int PREFERENCE_DIALOG_FONT_COLOR = 1;
	private static final int PREFERENCE_DIALOG_TEXT_COLOR = 2;

	private SettingFragment mPreferenceFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Setting");

		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingFragment())
				.commit();

		mPreferenceFragment = new SettingFragment();
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, mPreferenceFragment).commit();
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
 