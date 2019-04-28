package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.aiquran.aiquran.data.DataManager;
import com.example.aiquran.aiquran.databinding.ItemResultSearchBinding;
import com.example.aiquran.aiquran.models.BookMark;

import java.util.ArrayList;

public class ResultSearchAdapter extends RecyclerView.Adapter<ResultSearchAdapter.ViewHoder> implements Filterable {
    private ArrayList<BookMark> arrayBookAll;
    private ArrayList<BookMark> arrResult;
    private ItemResultSearchBinding binding;
    private LayoutInflater inflater;
    private ItemViewActionCallBack callBack;
    private MFilter mFilter = new MFilter();

    public ResultSearchAdapter(Context context, ArrayList<BookMark> arrayBook, String key) {
        getFilter().filter(key);
        this.arrResult = arrayBook;
        this.arrayBookAll = arrayBook;

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
        viewHoder.binding.setItem(arrResult.get(i));
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
        return arrResult.size();
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ItemResultSearchBinding binding;
        public ViewHoder(ItemResultSearchBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    private class MFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<BookMark> arrayList = new ArrayList<>();
            for (BookMark bookMark:arrayBookAll){
                if(bookMark.getNameAll().toLowerCase().contains(constraint.toString().toLowerCase())){
                    arrayList.add(bookMark);
                }
            }
            FilterResults results = new FilterResults();
            results.count = arrayList.size();
            results.values = arrayList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrResult = (ArrayList<BookMark>) results.values;
            notifyDataSetChanged();
        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position);
    }
}
