package com.example.aiquran.aiquran.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.SurasAdapter;
import com.example.aiquran.aiquran.databinding.FragmentSurasBinding;
import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class FragmentSuras extends Fragment implements SurasAdapter.ItemViewActionCallBack {
    private static FragmentSuras instance;
    private ArrayList<Suras> arraySuras;
    private FragmentSurasBinding binding;
    private SurasAdapter adapter;
    private int checkClick = -1;
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
        arraySuras.add(new Suras("2","Hello","Xin Chào"));
        arraySuras.add(new Suras("3","Hello","Xin Chào"));
        arraySuras.add(new Suras("4","Hello","Xin Chào"));
        arraySuras.add(new Suras("5","Hello","Xin Chào"));
        arraySuras.add(new Suras("6","Hello","Xin Chào"));
        arraySuras.add(new Suras("7","Hello","Xin Chào"));
        arraySuras.add(new Suras("8","Hello","Xin Chào"));
        arraySuras.add(new Suras("9","Hello","Xin Chào"));
        arraySuras.add(new Suras("10","Hello","Xin Chào"));
        arraySuras.add(new Suras("11","Hello","Xin Chào"));
        arraySuras.add(new Suras("12","Hello","Xin Chào"));
    }

    @Override
    public void onClick(int position) {
        if(position == checkClick){
            return;
        }
        if(checkClick != -1){
            arraySuras.get(checkClick).setCheck(false);
            adapter.notifyItemChanged(checkClick);
        }
        arraySuras.get(position).setCheck(true);
        adapter.notifyItemChanged(position);
        checkClick = position;
    }
}
