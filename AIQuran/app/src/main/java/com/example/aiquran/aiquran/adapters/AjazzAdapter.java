package com.example.aiquran.aiquran.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiquran.aiquran.databinding.ItemAjzaaBinding;
import com.example.aiquran.aiquran.databinding.ItemSuraBinding;
import com.example.aiquran.aiquran.models.Ajazz;
import com.example.aiquran.aiquran.models.Suras;

import java.util.ArrayList;

public class AjazzAdapter extends RecyclerView.Adapter<AjazzAdapter.ViewHoder> {
    private ArrayList<Ajazz> arrayAjazz;
    private ItemAjzaaBinding binding;
    private ItemViewActionCallBack callBack;
    private LayoutInflater inflater;

    public AjazzAdapter(Context context, ArrayList<Ajazz> arrayAjazz) {
        this.arrayAjazz = arrayAjazz;
        inflater = LayoutInflater.from(context);
    }

    public void setCallBack(ItemViewActionCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = ItemAjzaaBinding.inflate(inflater,viewGroup,false);
        return new ViewHoder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, final int i) {
        viewHoder.binding.setItem(arrayAjazz.get(i));
        viewHoder.binding.txtJoza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txtHezbTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txtHezbBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txt14Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txt14Bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txt12Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txt12Bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txt34Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
        viewHoder.binding.txt34Bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBack != null) {
                    callBack.onClick(i);
                }
            }
        });
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
        return arrayAjazz.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ItemAjzaaBinding binding;
        public ViewHoder(ItemAjzaaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface ItemViewActionCallBack {
        void onClick(int position);
    }
}
