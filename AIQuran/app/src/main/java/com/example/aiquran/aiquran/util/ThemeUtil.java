package com.example.aiquran.aiquran.util;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.models.Theme;

import java.util.ArrayList;


public class ThemeUtil {
    
    public static ArrayList<Theme> getThemeList(){
        ArrayList<Theme> themeArrayList = new ArrayList<>();
        themeArrayList.add(new Theme(R.style.AppTheme_RED, "#f44336","Red",  R.color.primaryColorRed, R.color.primaryDarkColorRed, R.color.secondaryColorRed));
        themeArrayList.add(new Theme(R.style.AppTheme_PINK, "#E91E63","Pink",  R.color.primaryColorPink, R.color.primaryDarkColorPink, R.color.secondaryColorPink));
        themeArrayList.add(new Theme(R.style.AppTheme_PURPLE, "#9C27B0","Purple",  R.color.primaryColorPurple, R.color.primaryDarkColorPurple, R.color.secondaryColorPurple));
        themeArrayList.add(new Theme(R.style.AppTheme_DEEPPURPLE, "#673AB7","Deep Purple", R.color.primaryColorDeepPurple, R.color.primaryDarkColorDeepPurple, R.color.secondaryColorDeepPurple));
        themeArrayList.add(new Theme(R.style.AppTheme_INDIGO, "#3F51B5","Indigo",  R.color.primaryColorIndigo, R.color.primaryDarkColorIndigo, R.color.secondaryColorIndigo));
        themeArrayList.add(new Theme(R.style.AppTheme_BLUE, "#2196F3","Blue",  R.color.primaryColorBlue, R.color.primaryDarkColorBlue, R.color.secondaryColorBlue));
        themeArrayList.add(new Theme(R.style.AppTheme_LIGHTBLUE, "#03A9F4","Light Blue", R.color.primaryColorLightBlue, R.color.primaryDarkColorLightBlue, R.color.secondaryColorLightBlue));
        themeArrayList.add(new Theme(R.style.AppTheme_CYAN, "#00BCD4","Cyan",  R.color.primaryColorCyan, R.color.primaryDarkColorCyan, R.color.secondaryColorCyan));
        themeArrayList.add(new Theme(R.style.AppTheme_TEAL, "#009688","Teal",  R.color.primaryColorTeal, R.color.primaryDarkColorTeal, R.color.secondaryColorTeal));
        themeArrayList.add(new Theme(R.style.AppTheme_GREEN, "#4CAF50","Green", R.color.primaryColorGreen, R.color.primaryDarkColorGreen, R.color.secondaryColorGreen));
        themeArrayList.add(new Theme(R.style.AppTheme_LIGHTGREEN,"#8BC34A","Light Green" , R.color.primaryColorLightGreen, R.color.primaryDarkColorLightGreen, R.color.secondaryColorLightGreen));
        themeArrayList.add(new Theme(R.style.AppTheme_LIME,"#CDDC39","Lime",  R.color.primaryColorLime, R.color.primaryDarkColorLime, R.color.secondaryColorLime));
        themeArrayList.add(new Theme(R.style.AppTheme_YELLOW,"#FFEB3B","Yellow", R.color.primaryColorYellow, R.color.primaryDarkColorYellow, R.color.secondaryColorYellow));
        themeArrayList.add(new Theme(R.style.AppTheme_AMBER,"#FFC107","Amber",  R.color.primaryColorAmber, R.color.primaryDarkColorAmber, R.color.secondaryColorAmber));
        themeArrayList.add(new Theme(R.style.AppTheme_ORANGE,"#FF9800","Orange",   R.color.primaryColorOrange, R.color.primaryDarkColorOrange, R.color.secondaryColorOrange));
        themeArrayList.add(new Theme(R.style.AppTheme_DEEPORANGE,"#FF5722","Deep Orange" , R.color.primaryColorDeepOrange, R.color.primaryDarkColorDeepOrange, R.color.secondaryColorDeepOrange));
        themeArrayList.add(new Theme(R.style.AppTheme_BROWN,"#795548","Brown",   R.color.primaryColorBrown, R.color.primaryDarkColorBrown, R.color.secondaryColorBrown));
        themeArrayList.add(new Theme(R.style.AppTheme_GRAY,"#9E9E9E","Grey",   R.color.primaryColorGray, R.color.primaryDarkColorGray, R.color.secondaryColorGray));
        themeArrayList.add(new Theme(R.style.AppTheme_BLUEGRAY,"#607D8B","Blue Grey",   R.color.primaryColorBlueGray, R.color.primaryDarkColorBlueGray, R.color.secondaryColorBlueGray));
        return themeArrayList;
    }
}
