package com.example.aiquran.aiquran.activities;

import com.example.aiquran.aiquran.R;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment.ColorPickerDialogListener;
import com.github.danielnilsson9.colorpickerview.preference.ColorPreference;
import com.github.danielnilsson9.colorpickerview.preference.ColorPreference.OnShowDialogListener;

import android.app.DialogFragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements ColorPickerDialogListener {

	private static final int DIALOG_ID = 0;
	private static final int PREFERENCE_DIALOG_FONT_COLOR = 1;
	private static final int PREFERENCE_DIALOG_TEXT_COLOR = 2;
	
	
	private ExamplePreferenceFragment mPreferenceFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Setting");

		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new ExamplePreferenceFragment())
				.commit();

		mPreferenceFragment = new ExamplePreferenceFragment();
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

	public static class ExamplePreferenceFragment extends PreferenceFragment implements 
		ColorPickerDialogListener {
		

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);			
			addPreferencesFromResource(R.xml.preferences);

			ColorPreference FontColor = (ColorPreference) findPreference("FontColor");
			FontColor.setOnShowDialogListener(new OnShowDialogListener() {
				
				@Override
				public void onShowColorPickerDialog(String title, int currentColor) {

					ColorPickerDialogFragment dialog = ColorPickerDialogFragment
							.newInstance(PREFERENCE_DIALOG_FONT_COLOR, "Font MyColor", null, currentColor, false);

					dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.LightPickerDialogTheme);
				    dialog.show(getFragmentManager(), "pre_dialog");					
				}				
			});
			ColorPreference TextStrokeColor = (ColorPreference) findPreference("TextStrokeColor");
			TextStrokeColor.setOnShowDialogListener(new OnShowDialogListener() {

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
		
	}
	
}
 