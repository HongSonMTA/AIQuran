package com.example.aiquran.aiquran.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiquran.aiquran.R;

public class FragmentSuras extends Fragment {
    private static FragmentSuras instance;

    public static FragmentSuras getInstance(){
        if(instance == null){
            instance = new FragmentSuras();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suras,container,false);
        return view;
    }
}
