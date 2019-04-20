package com.example.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.model.InstansiItem;
import com.example.project.view.Detail_Item;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<InstansiItem> instansiItems;
    private Context context;

    public Adapter( Context context, List<InstansiItem> instansiItems) {
        this.instansiItems = instansiItems;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Holder holder, final int i) {
        holder.bind(i);
    }

    @Override
    public int getItemCount() {
        return instansiItems.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tv_id, tv_idKab, tv_namaKab, tv_Jeniss, tv_nama, tv_no, tv_alam, tv_latt, tv_longg1;
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
        }

        public void bind(final int i) {
            Intent x = new Intent(context, Detail_Item.class);
            x.putExtra("id", instansiItems.get(i).getId());
            x.putExtra("id_kab", instansiItems.get(i).getIdKabupaten());
            x.putExtra("nm_kab", instansiItems.get(i).getNamaKabupaten());
            x.putExtra("jenis", instansiItems.get(i).getJenisInstansi());
            x.putExtra("nm_ins", instansiItems.get(i).getNamaInstansi());
            x.putExtra("no_ins", instansiItems.get(i).getNomorInstansi());
            x.putExtra("alamat", instansiItems.get(i).getAlamatInstansi());
            x.putExtra("lat", instansiItems.get(i).getLat());
            x.putExtra("long", instansiItems.get(i).getLong());
            x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(x);
            Toast.makeText(context, instansiItems.get(i).getNamaInstansi(), Toast.LENGTH_SHORT).show();
        }
    }
}
