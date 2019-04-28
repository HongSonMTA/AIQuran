package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.data.FileManager;
import com.example.aiquran.aiquran.models.Book;

import java.util.ArrayList;


public class SlidePagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private Book book;
    private ItemViewCallBack callBack;
    private ArrayList<String> specialWords;
    private FileManager fileManager;


    public void setCallBack(ItemViewCallBack callBack) {
        this.callBack = callBack;
    }

    public SlidePagerAdapter(Context context, Book book) {
        this.context = context;
        this.book = book;
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

        getSpecialWords();
        txtContentOne.setText(initSpan(book.getPagesString().get(position), specialWords));
        txtContentOne.setMovementMethod(LinkMovementMethod.getInstance());

        container.addView(view);
        return view;
    }

    private void getSpecialWords() {
        fileManager = new FileManager(context);
        specialWords = fileManager.getAllSpecialWord();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

    public interface ItemViewCallBack {
        void onClick(int position);
    }

    private SpannableString initSpan(String str, ArrayList<String> keyWords) {
        SpannableString ss = new SpannableString(str);

        for (String s : keyWords) {
            int ofset = 0;
            int start = 0;
            int length = s.length();
            start = str.indexOf(s, 0);
            while (start > 0) {
                ForegroundColorSpan blue = new ForegroundColorSpan(Color.BLUE);
                ClickableSpan clickableSpan = new ClickableSpan() {

                    @Override
                    public void onClick(View widget) {
                        TextView tv = (TextView) widget;

                        Spanned s = (Spanned) tv.getText();
                        int start = s.getSpanStart(this);
                        int end = s.getSpanEnd(this);

                        String str = s.toString().substring(start, end);
                        onClickText(str);
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setUnderlineText(false);
                    }
                };
                ss.setSpan(clickableSpan, start, start + length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ofset = start + length;
                start = str.indexOf(s, ofset);
            }
        }
        return ss;
    }

    private void onClickText(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View mView = inflater.inflate(R.layout.message_dialog, null);
        TextView txtMessage1 = mView.findViewById(R.id.txt_message1);
        TextView txtMessage2 = mView.findViewById(R.id.txt_message2);
        //txtMessage1.setText(book.getPages().get(position).getDescribe());
        txtMessage1.setText(str);
        builder.setView(mView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
