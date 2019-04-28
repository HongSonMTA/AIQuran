package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.databinding.ItemPageBinding;
import com.example.aiquran.aiquran.models.Book;
import com.example.aiquran.aiquran.models.ContentBook;

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
        viewHoder.binData(book,i);
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

            ArrayList<String> keyWords = new ArrayList<>();
            keyWords.add("Most Gracious");
            keyWords.add("Thou hast bestowed Thy Grace");
            keyWords.add("the Cherisher and Sustainer");
            keyWords.add("Make not mischief on the earth,");
            keyWords.add("from their Lord");
            binding.txtContentOne.setText(initSpan(book1.getPagesString().get(page),keyWords));
            binding.txtContentOne.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position,View view);
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
                       // Toast.makeText(inflater.getContext(),"dfghjkj",Toast.LENGTH_LONG).show();
                        TextView tv = (TextView) widget;

                        Spanned s = (Spanned) tv.getText();
                        int start = s.getSpanStart(this);
                        int end = s.getSpanEnd(this);

                        String str = s.toString().substring(start,end);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(inflater.getContext());

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
