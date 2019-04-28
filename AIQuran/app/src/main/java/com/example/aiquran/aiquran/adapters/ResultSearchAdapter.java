package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiquran.aiquran.databinding.ItemResultSearchBinding;
import com.example.aiquran.aiquran.models.BookMark;

import java.util.ArrayList;

public class ResultSearchAdapter extends RecyclerView.Adapter<ResultSearchAdapter.ViewHoder> {
    private ArrayList<BookMark> arrayBook;
    private ItemResultSearchBinding binding;
    private LayoutInflater inflater;
    private ItemViewActionCallBack callBack;

    public ResultSearchAdapter(Context context, ArrayList<BookMark> arrayBook) {
        this.arrayBook = arrayBook;
        inflater = LayoutInflater.from(context);
    }

    public void setCallBack(ItemViewActionCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ItemResultSearchBinding.inflate(inflater,viewGroup,false);
        return new ViewHoder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, final int i) {
        viewHoder.binding.setItem(arrayBook.get(i));
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
        return arrayBook.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ItemResultSearchBinding binding;
        public ViewHoder(ItemResultSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position);
    }
}
