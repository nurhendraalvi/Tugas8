package com.example.project.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.R;
import com.example.project.entity.DataInstansi;
import com.example.project.view.MainContact;

import java.util.List;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.Holder> {
    Context context;
    List<DataInstansi> list;
    MainContact.hapus view;
    @NonNull
    @Override
    public LikeAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_like, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LikeAdapter.Holder holder, int i) {
        holder.bind(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int i) {
        }
    }
}
