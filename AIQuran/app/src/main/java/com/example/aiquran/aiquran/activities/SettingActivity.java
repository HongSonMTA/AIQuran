package com.example.aiquran.aiquran.activities;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.ColorAdapter;
import com.example.aiquran.aiquran.models.MyColor;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment;
import com.github.danielnilsson9.colorpickerview.dialog.ColorPickerDialogFragment.ColorPickerDialogListener;
import com.github.danielnilsson9.colorpickerview.preference.ColorPreference;
import com.github.danielnilsson9.colorpickerview.preference.ColorPreference.OnShowDialogListener;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.Preference;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

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
//			Preference Choose = findPreference("ChooseThems");
//			setOnShowDialogListener
//			Preference preference = new Preference(getActivity());
//			preference.setKey("ChooseThems");
//			preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//				@Override
//				public boolean onPreferenceClick(Preference preference) {
//					Log.e("onPreferenceClick", "onPreferenceClick: " );
//					dialogSelectColor();
//					return true;
//				}
//			});
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
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle("Choose Theme");
			 View view = getLayoutInflater().inflate(R.layout.list_color, null);
			RecyclerView rcv_listColor = view.findViewById(R.id.rcv_list_color);
			ArrayList<MyColor> myColors = new ArrayList<>();
			myColors.add(new MyColor("Red", "#f44336"));
			myColors.add(new MyColor("Pink", "#E91E63"));
			myColors.add(new MyColor("Purple", "#9C27B0"));
			myColors.add(new MyColor("Deep Purple", "#673AB7"));
			myColors.add(new MyColor("Indigo", "#3F51B5"));
			myColors.add(new MyColor("Blue", "#2196F3"));
			myColors.add(new MyColor("Light Blue", "#03A9F4"));
			myColors.add(new MyColor("Cyan", "#00BCD4"));
			myColors.add(new MyColor("Teal", "#009688"));
			myColors.add(new MyColor("Green", "#4CAF50"));
			myColors.add(new MyColor("Light Green", "#8BC34A"));
			myColors.add(new MyColor("Lime", "#CDDC39"));
			myColors.add(new MyColor("Yellow", "#FFEB3B"));
			myColors.add(new MyColor("Amber", "#FFC107"));
			myColors.add(new MyColor("Orange", "#FF9800"));
			myColors.add(new MyColor("Deep Orange", "#FF5722"));
			myColors.add(new MyColor("Brown", "#795548"));
			myColors.add(new MyColor("Grey", "#9E9E9E"));
			myColors.add(new MyColor("Blue Grey", "#607D8B"));

			ColorAdapter colorAdapter = new ColorAdapter(myColors, builder.getContext());
			rcv_listColor.setAdapter(colorAdapter);
			builder.setView(view);

			builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});

			AlertDialog dialog = builder.create();
			dialog.show();
		}

		@Override
		public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, android.preference.Preference preference) {
            switch (preference.getKey()){
                case "ChooseThems": {
                    dialogSelectColor();
                    return true;
                }
                case "DownloadAudio": {
                    Intent intent = new Intent(getActivity(), ActivityDownloadAudio.class);
                    startActivity(intent);
                    return true;
                }
				case "DownloadTafsir": {
					Intent intent = new Intent(getActivity(), ActivityDownloadAudio.class);
					startActivity(intent);
					return true;
				}
                default: return  false;
            }
		}
	}
}
 