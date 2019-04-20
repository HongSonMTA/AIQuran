package com.example.aiquran.aiquran.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.activities.AudioActivity;
import com.example.aiquran.aiquran.activities.PagingActivity;
import com.example.aiquran.aiquran.activities.ScrollActivity;
import com.example.aiquran.aiquran.adapters.SurasAdapter;
import com.example.aiquran.aiquran.databinding.FragmentSurasBinding;
import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class FragmentSuras extends Fragment implements SurasAdapter.ItemViewActionCallBack {
    private static FragmentSuras instance;
    private ArrayList<Suras> arraySuras;
    private FragmentSurasBinding binding;
    private SurasAdapter adapter;
    private String[] listMenu = new String[]{"Scrolling", "Paging", "AI-Quran TV"};

    public static FragmentSuras getInstance(){
        if(instance == null){
            instance = new FragmentSuras();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_suras,container,false);
        View view = binding.getRoot();
        adapter = new SurasAdapter(getContext(), arraySuras);
//        binding.lvSuras.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.lvSuras.setAdapter(adapter);
        adapter.setCallBack(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arraySuras = new ArrayList<>();
        arraySuras.add(new Suras("1","Hello","Xin Chào"));
        arraySuras.add(new Suras("2","Hello 2","Xin Chào"));
        arraySuras.add(new Suras("3","Hello 3","Xin Chào"));
        arraySuras.add(new Suras("4","Hello 4","Xin Chào"));
        arraySuras.add(new Suras("5","Hello 5","Xin Chào"));
        arraySuras.add(new Suras("6","Hello 6","Xin Chào"));
        arraySuras.add(new Suras("7","Hello 7","Xin Chào"));
        arraySuras.add(new Suras("8","Hello 8","Xin Chào"));
        arraySuras.add(new Suras("9","Hello 9","Xin Chào"));
        arraySuras.add(new Suras("10","Hello 10","Xin Chào"));
        arraySuras.add(new Suras("11","Hello 11","Xin Chào"));
        arraySuras.add(new Suras("12","Hello 12","Xin Chào"));
    }

    @Override
    public void onClick(int position) {
        TextView txt = new TextView(getContext());
        txt.setText("Choose the suitable method to explore the Holy Quran");
        txt.setPadding(20,20,20,20);
        txt.setTextSize(25);
        txt.setTypeface(null, Typeface.BOLD);
        txt.setTextColor(Color.BLACK);
        final View mView = getLayoutInflater().inflate(R.layout.checkbox, null);
        CheckBox mCheckBox = mView.findViewById(R.id.cb_donotshowagain);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        mBuilder.setTitle("Choose the suitable method to explore the Holy Quran");
        //mBuilder.setCustomTitle(txt);
        final  int[] choose = new int[1];
        mBuilder.setSingleChoiceItems(listMenu, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // dialog.dismiss();
                choose[0]=which;
            }
        });
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("Choose", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext(),ScrollActivity.class);
                switch (choose[0]){
                    case 1:
                        intent = new Intent(getContext(), PagingActivity.class);
                        break;
                    case 2:
                        intent = new Intent(getContext(), AudioActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width =(int) dm.widthPixels * 80/100;
        int height = dm.heightPixels * 55/100;
        alertDialog.getWindow().setLayout(width, height); //Controlling width and height.
//        Intent intent = new Intent(getContext(),ScrollActivity.class);
//        startActivity(intent);
    }
}
