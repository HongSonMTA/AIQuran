package com.example.aiquran.aiquran.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aiquran.aiquran.R;
import com.example.aiquran.aiquran.adapters.DownloadAudioAdapter;
import com.example.aiquran.aiquran.models.Book;
import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class ActivityDownloadAudio extends AppCompatActivity implements DownloadAudioAdapter.ItemViewActionCallBack {

    private RecyclerView rcDownload;
    private DownloadAudioAdapter audioAdapter;
    private ArrayList<Suras> arraySuras;
    private TextView tvDownloadSelected;
    private TextView tvSelectDeSelectAll;
    private int key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_audio);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Setting/Download Audio");
        Intent intent = getIntent();
        key = intent.getIntExtra("Key", 0);
        initView();
    }

    private void initView() {
        if(key == 1) {
            arraySuras = new ArrayList<>();
            arraySuras.add(new Suras("1", "Hello", "Xin Chào"));
            arraySuras.add(new Suras("2", "Hello 2", "Xin Chào"));
            arraySuras.add(new Suras("3", "Hello 3", "Xin Chào"));
            arraySuras.add(new Suras("4", "Hello 4", "Xin Chào"));
            arraySuras.add(new Suras("5", "Hello 5", "Xin Chào"));
            arraySuras.add(new Suras("6", "Hello 6", "Xin Chào"));
            arraySuras.add(new Suras("7", "Hello 7", "Xin Chào"));
            arraySuras.add(new Suras("8", "Hello 8", "Xin Chào"));
            arraySuras.add(new Suras("9", "Hello 9", "Xin Chào"));
            arraySuras.add(new Suras("10", "Hello 10", "Xin Chào"));
            arraySuras.add(new Suras("11", "Hello 11", "Xin Chào"));
            arraySuras.add(new Suras("12", "Hello 12", "Xin Chào"));


            tvSelectDeSelectAll = findViewById(R.id.tv_select_deselect_all);
            tvDownloadSelected = findViewById(R.id.tv_download_selected);
            tvDownloadSelected.setOnClickListener(onClickListener);
            tvSelectDeSelectAll.setOnClickListener(onClickListener);

            rcDownload = findViewById(R.id.recycler_view_download_audio);
            audioAdapter = new DownloadAudioAdapter(arraySuras, this);
            audioAdapter.setCallBack(this);
            rcDownload.setAdapter(audioAdapter);
        }
    }

    @Override
    public void onClick(int position) {

        boolean check = arraySuras.get(position).isDownloadSelected();
        if (check) {
            arraySuras.get(position).setDownloadSelected(false);
        } else {
            arraySuras.get(position).setDownloadSelected(true);
        }
        audioAdapter.notifyItemChanged(position);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_download_selected:
                    dialogDownloading();
                    break;
                case R.id.tv_select_deselect_all:
                    selectDeselectAll(!isSelecAll());
                    break;
                default:
                    break;
            }
        }
    };

    private boolean isSelecAll() {
        for (int i = 0; i < arraySuras.size(); i++) {
            if (!arraySuras.get(i).isDownloadSelected())
                return false;
        }
        return true;
    }


    private void selectDeselectAll(boolean true_false) {
        for (int i = 0; i < arraySuras.size(); i++) {
            arraySuras.get(i).setDownloadSelected(true_false);
        }
        audioAdapter.notifyDataSetChanged();
    }

    private void dialogDownloading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Downloading Audio");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
