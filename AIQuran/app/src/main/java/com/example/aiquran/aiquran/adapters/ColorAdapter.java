package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.models.MyColor;

import java.util.ArrayList;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private ArrayList<MyColor> myColors;
    private Context context;
    private LayoutInflater inflater;
    private ItemColorCallBack colorCallBack;

    public void setColorCallBack(ItemColorCallBack colorCallBack) {
        this.colorCallBack = colorCallBack;
    }

    public ColorAdapter(ArrayList<MyColor> myColors, Context context) {
        this.myColors = myColors;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = inflater.inflate(R.layout.item_list_color, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.layout.setBackgroundColor(myColors.get(i).getColor());
        viewHolder.tvNameColor.setText(myColors.get(i).getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (colorCallBack != null) {
                    colorCallBack.onselectColor(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myColors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private TextView tvNameColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout_item_list_color);
            tvNameColor = itemView.findViewById(R.id.tv_nameColor);
        }
    }

    public interface ItemColorCallBack {
        void onselectColor(int position);
    }
}
