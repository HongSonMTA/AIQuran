package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.models.Book;


public class SlidePagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private Book book ;
    private  ItemViewCallBack callBack;

    public void setCallBack(ItemViewCallBack callBack) {
        this.callBack = callBack;
    }

    public SlidePagerAdapter(Context context, Book book) {
        this.context = context;
        this.book=book;
    }

    @Override
    public int getCount() {
        return book.getPagesString().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_page, container, false);
        TextView txtContentOne = view.findViewById(R.id.txt_contentOne);
        TextView txtDecribe = view.findViewById(R.id.txt_describe);
        TextView txtContentTwo = view.findViewById(R.id.txt_contentTwo);

        txtContentOne.setText(book.getPagesString().get(position));

        txtDecribe.setText("Decribe");
        txtContentTwo.setText("Content two");
        txtDecribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBack!=null){
                    callBack.onClick(position);
                }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

    public interface ItemViewCallBack {
        void onClick(int position);
    }
}
