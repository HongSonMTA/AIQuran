package com.example.aiquran.aiquran.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aiquran.aiquran.fragments.FragmentAjzaa;
import com.example.aiquran.aiquran.fragments.FragmentSuras;


public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return FragmentSuras.getInstance();
            case 1:
                return FragmentAjzaa.getInstance();
        }
            return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Suras";
            case 1:
                return "Ajzaa";
        }
        return super.getPageTitle(position);
    }
}
