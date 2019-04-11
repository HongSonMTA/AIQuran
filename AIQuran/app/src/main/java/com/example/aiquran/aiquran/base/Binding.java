package com.example.aiquran.aiquran.base;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class Binding {
    @BindingAdapter("app:score")
    public static void setScore(TextView textView , int ayah){
        textView.setText(ayah +"");
    }
}
