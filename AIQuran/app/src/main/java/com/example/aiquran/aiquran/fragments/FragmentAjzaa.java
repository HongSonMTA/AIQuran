package com.example.aiquran.aiquran.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.databinding.FragmentAjzaaBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentAjzaa extends Fragment {
    private static FragmentAjzaa instance;
    private FragmentAjzaaBinding binding;
    private ListView listView;
    private ArrayList<String> myList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private String[] listMenu = new String[]{"ScrollView", "Pages", "Video"};

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
        initList();
        return view;
    }

    private void initList() {
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        myList.add("6");
        myList.add("7");
        myList.add("8");
        myList.add("9");
        myList.add("10");
        adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_expandable_list_item_1, myList);
        binding.listView.setAdapter(adapter);
        final View mView = getLayoutInflater().inflate(R.layout.checkbox, null);
        CheckBox mCheckBox = mView.findViewById(R.id.cb_donotshowagain);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                mBuilder.setTitle("Title" + myList.get(position));
                mBuilder.setSingleChoiceItems(listMenu, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // dialog.dismiss();
                    }
                });
                mBuilder.setView(mView);
                mBuilder.setPositiveButton("Choice", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                //mBuilder.setNegativeButton("Cancle", null);
                AlertDialog alertDialog = mBuilder.create();
                alertDialog.show();
            }
        });
    }
}
