package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiquran.aiquran.databinding.ItemBookMarkBinding;
import com.example.aiquran.aiquran.databinding.ItemPageBinding;
import com.example.aiquran.aiquran.databinding.ItemSuraBinding;
import com.example.aiquran.aiquran.models.Book;
import com.example.aiquran.aiquran.models.ContentBook;
import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.ViewHoder> {
    private Book book;
    private ItemPageBinding binding;
    private LayoutInflater inflater;
    private ItemViewActionCallBack callBack;

    public ScrollAdapter(Context context, Book book) {
        this.book = book;
        inflater = LayoutInflater.from(context);
    }

    public void setCallBack(ItemViewActionCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ItemPageBinding.inflate(inflater,viewGroup,false);
        return new ViewHoder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, final int i) {
        viewHoder.binData(book.getPages().get(i));
        viewHoder.binding.txtDescribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBack!= null){
                    callBack.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return book.getPages().size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ItemPageBinding binding;
        public ViewHoder(ItemPageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void binData(ContentBook contentBook){
            binding.txtContentOne.setText(contentBook.getContentOne());
            binding.txtDescribe.setText(contentBook.getDescribe());
            binding.txtContentTwo.setText(contentBook.getContentTwo());
        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position);
    }
}
