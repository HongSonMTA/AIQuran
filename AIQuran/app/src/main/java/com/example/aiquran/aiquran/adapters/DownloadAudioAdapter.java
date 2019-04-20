package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;

import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class DownloadAudioAdapter extends RecyclerView.Adapter<DownloadAudioAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Suras> arraySuras;
    private LayoutInflater inflater;
    private ItemViewActionCallBack callBack;


    public DownloadAudioAdapter(ArrayList<Suras> arraySuras, Context context) {
        this.arraySuras = arraySuras;
        inflater = LayoutInflater.from(context);
    }

    public void setCallBack(ItemViewActionCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemDownload = inflater.inflate(R.layout.item_download_audio, viewGroup, false);
        return new ViewHolder(itemDownload);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(arraySuras.get(i).getId());
       // viewHolder.checkBox.setChecked(arraySuras.get(i).isDownloadSelected());
        //viewHolder.ivCheckbox.

        boolean check = arraySuras.get(i).isDownloadSelected();
        if (check){
            viewHolder.ivCheckbox.setBackgroundResource(R.drawable.ic_check_box_pink_24dp);
        }else {
            viewHolder.ivCheckbox.setBackgroundResource(R.drawable.check_box_black_24dp);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolder extends RecyclerView.ViewHolder {

      //  CheckBox checkBox;
        TextView textView;
        ImageView ivCheckbox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // checkBox = itemView.findViewById(R.id.cb_download_audio);
            textView = itemView.findViewById(R.id.tv_name_download_audio);
            ivCheckbox = itemView.findViewById(R.id.iv_checkbox);
        }
    }

    public interface ItemViewActionCallBack {
        void onClick(int position);
    }
}
