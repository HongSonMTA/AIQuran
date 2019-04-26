package com.example.aiquran.aiquran.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.base.BaseActivity;
import com.example.aiquran.aiquran.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private ActivitySearchBinding binding;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Search");
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search);
        initView();
    }

    private void initView() {
        list.add("All");
        list.add("Java");
        list.add("Php");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        binding.spinner.setAdapter(adapter);
        binding.btnSearch.setOnClickListener(this);
        binding.btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_delete:{
                if(binding.edtSearch.getText()!= null){
                    binding.edtSearch.setText("");
                }
                break;
            }
            case R.id.btn_search:{
                Intent intent = new Intent(this,ResultSearchActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
