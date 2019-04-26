package com.example.aiquran.aiquran.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.models.Theme;
import com.example.aiquran.aiquran.util.ThemeUtil;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {
    public static final String KEY_CURRENT_THEME = "id_current_theme";
    private int idCurrentTheme;
    private int positionTheme;
    private SharedPreferences sharedPref;
    private ArrayList<Theme> arrTheme= ThemeUtil.getThemeList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        idCurrentTheme = sharedPref.getInt(KEY_CURRENT_THEME, R.style.AppTheme_RED);
        positionTheme = sharedPref.getInt("ID_BG_TABBAR",0);
        setTheme(arrTheme.get(positionTheme).getId());
    }

    public void setAppTheme(int position) {
        positionTheme=position;
        if(idCurrentTheme != arrTheme.get(position).getId()) {
            idCurrentTheme= arrTheme.get(position).getId();

            SharedPreferences.Editor spedit = sharedPref.edit();
            spedit.putInt(KEY_CURRENT_THEME, idCurrentTheme);
            spedit.apply();

            recreate();
        }
    }
    public  int getIdBackgroundTab(){
        return arrTheme.get(positionTheme).getPrimaryColor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(idCurrentTheme != sharedPref.getInt(KEY_CURRENT_THEME, R.style.AppTheme_RED)){
            recreate();
        }
    }
}
