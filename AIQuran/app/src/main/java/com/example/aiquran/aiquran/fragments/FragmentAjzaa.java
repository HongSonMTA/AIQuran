package com.example.aiquran.aiquran.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.activities.AudioActivity;
import com.example.aiquran.aiquran.activities.PagingActivity;
import com.example.aiquran.aiquran.activities.ScrollActivity;
import com.example.aiquran.aiquran.adapters.AjazzAdapter;
import com.example.aiquran.aiquran.adapters.SurasAdapter;
import com.example.aiquran.aiquran.databinding.FragmentAjzaaBinding;
import com.example.aiquran.aiquran.models.Ajazz;
import com.example.aiquran.aiquran.models.Suras;
import com.example.aiquran.aiquran.models.SurasNames;

import java.util.ArrayList;
import java.util.List;

public class FragmentAjzaa extends Fragment implements AjazzAdapter.ItemViewActionCallBack {
    private static FragmentAjzaa instance;
    private FragmentAjzaaBinding binding;
    private ArrayList<Ajazz> arrAjazz;
    private AjazzAdapter adapter;
    private SurasNames surasNames = new SurasNames();
    private ArrayList<Suras> arraySuras;

    private String[] listMenu = new String[]{"Scrolling", "Paging", "AI-Quran TV"};

    public static FragmentAjzaa getInstance() {
        if (instance == null) {
            instance = new FragmentAjzaa();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_ajzaa, container, false);
        View view = binding.getRoot();
        adapter = new AjazzAdapter(getContext(), arrAjazz);
        binding.lvSuras.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.lvSuras.setAdapter(adapter);
        adapter.setCallBack(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSuras();
        arrAjazz = new ArrayList<>();
        arrAjazz.add(new Ajazz("Joza 1", "Hezb 1", "Hezb 2", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 2", "Hezb 3", "Hezb 4", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 3", "Hezb 5", "Hezb 6", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 4", "Hezb 7", "Hezb 8", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 5", "Hezb 9", "Hezb 10", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 6", "Hezb 11", "Hezb 12", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 7", "Hezb 13", "Hezb 14", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 8", "Hezb 15", "Hezb 16", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
        arrAjazz.add(new Ajazz("Joza 9", "Hezb 17", "Hezb 18", "1/4", "1/2", "3/4", "1/4", "1/2", "3/4"));
    }

    private void initSuras() {
        arraySuras = new ArrayList<>();
        for (int i = 0; i < 114; i++) {
            arraySuras.add(new Suras(i + 1 + "", surasNames.getSuraNameEn(i), surasNames.getSurasNameAr(i)));
        }
    }
    @Override
    public void onClick(final int position) {
        TextView txt = new TextView(getContext());
        txt.setText("Choose the suitable method to explore the Holy Quran");
        txt.setPadding(20, 20, 20, 20);
        txt.setTextSize(25);
        txt.setTypeface(null, Typeface.BOLD);
        txt.setTextColor(Color.BLACK);

        final View mView = getLayoutInflater().inflate(R.layout.checkbox, null);
        CheckBox mCheckBox = mView.findViewById(R.id.cb_donotshowagain);

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
        mBuilder.setTitle("Choose the suitable method to explore the Holy Quran");
        //mBuilder.setCustomTitle(txt);
        final int[] choose = new int[1];
        mBuilder.setSingleChoiceItems(listMenu, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choose[0] = which;
            }
        });
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("Choose", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent  intent = new Intent(getContext(), ScrollActivity.class);;
                switch (choose[0]) {
                    case 1:
                        intent = new Intent(getContext(), PagingActivity.class);
                        break;
                    case 2:
                        intent = new Intent(getContext(), AudioActivity.class);
                        break;
                }
                intent.putExtra("ID_SURAS", position+1);
                intent.putExtra("SURAS_NAME",arraySuras.get(position).getOriginalWords());
                startActivity(intent);
            }
        });
        AlertDialog alertDialog = mBuilder.create();
        alertDialog.show();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = (int) dm.widthPixels * 80 / 100;
        int height = dm.heightPixels * 55 / 100;
        alertDialog.getWindow().setLayout(width, height); //Controlling width and height.
    }
}
