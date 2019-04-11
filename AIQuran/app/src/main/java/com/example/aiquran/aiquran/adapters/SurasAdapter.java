package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiquran.aiquran.databinding.ItemSuraBinding;
import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class SurasAdapter  extends RecyclerView.Adapter<SurasAdapter.ViewHoder> {
    private ArrayList<Suras> arraySuras;
    private ItemSuraBinding binding;
    private ItemViewActionCallBack callBack;
    private LayoutInflater inflater;

    public SurasAdapter(Context context,ArrayList<Suras> arraySuras) {
        this.arraySuras = arraySuras;
        inflater = LayoutInflater.from(context);
    }

    public void setCallBack(ItemViewActionCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ItemSuraBinding.inflate(inflater,viewGroup,false);
        return new ViewHoder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, final int i) {
        viewHoder.binding.setItem(arraySuras.get(i));
        viewHoder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arraySuras.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ItemSuraBinding binding;
        public ViewHoder(ItemSuraBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position);
    }
}
