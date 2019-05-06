package com.example.project.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.entity.AppDatabase;
import com.example.project.entity.DataInstansi;
import com.example.project.view.MainContact;

import java.util.List;

public class LikeAdapter extends RecyclerView.Adapter<LikeAdapter.Holder> {
    private Context context;
    private List<DataInstansi> list;
    private MainContact.hapus view;

    public LikeAdapter(Context context, List<DataInstansi> list, MainContact.hapus view) {
        this.context = context;
        this.list = list;
        this.view = view;
    }

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
    private RelativeLayout open_Detail;
    private TextView tv_id, tv_idKab, tv_namaKab, tv_Jeniss, tv_nama, tv_no, tv_alam, tv_latt, tv_longg1;
    private ImageButton img_btn;
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_idKab = itemView.findViewById(R.id.tv_id_kab);
            tv_namaKab = itemView.findViewById(R.id.tv_nama_kab);
            tv_Jeniss = itemView.findViewById(R.id.tv_jenis);
            tv_nama = itemView.findViewById(R.id.tv_nama_ins);
            tv_no = itemView.findViewById(R.id.tv_no_ins);
            tv_alam = itemView.findViewById(R.id.tv_alamat);
            tv_latt = itemView.findViewById(R.id.tv_lat);
            tv_longg1 = itemView.findViewById(R.id.tv_long);
            open_Detail = itemView.findViewById(R.id.openDetail);
            img_btn = itemView.findViewById(R.id.btn_like);

        }

        public void bind(int i) {
        }
    }
}
