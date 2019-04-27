package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.aiquran.aiquran.databinding.ItemPageBinding;
import com.example.aiquran.aiquran.models.Book;
import com.example.aiquran.aiquran.models.ContentBook;


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
        viewHoder.binData(book,i);
        viewHoder.binding.txtDescribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBack!= null){
                    callBack.onClick(i,v);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return book.getPagesString().size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ItemPageBinding binding;
        public ViewHoder(ItemPageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void binData(Book book1,int page){
            binding.txtContentOne.setText(book1.getPagesString().get(page));
            binding.txtDescribe.setText("Descripble");
            binding.txtContentTwo.setText("Content ...");
        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position,View view);
    }
}
