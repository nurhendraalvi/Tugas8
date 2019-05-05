package com.example.project.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.entity.AppDatabase;
import com.example.project.entity.DataInstansi;
import com.example.project.model.InstansiItem;
import com.example.project.view.Activity.Detail_Item;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<InstansiItem> instansiItems;
    private Context context;
    private String id, idkab, namakab, jenisins, namains, noins,alamat, lat, longg;
    AppDatabase appDatabase;

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
        private RelativeLayout open_D;
        private TextView tv_id, tv_idKab, tv_namaKab, tv_Jeniss, tv_nama, tv_no, tv_alam, tv_latt, tv_longg1;
        private ImageButton img_btn;

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
            open_D = itemView.findViewById(R.id.openDetail);
            img_btn = itemView.findViewById(R.id.btn_like);
            appDatabase = AppDatabase.iniDb(context);
        }

        public void bind(final int i) {
            tv_id.setText(instansiItems.get(i).getId());
            tv_idKab.setText(instansiItems.get(i).getIdKabupaten());
            tv_namaKab.setText(instansiItems.get(i).getNamaKabupaten());
            tv_Jeniss.setText(instansiItems.get(i).getJenisInstansi());
            tv_nama.setText(instansiItems.get(i).getNamaInstansi());
            tv_no.setText(instansiItems.get(i).getNomorInstansi());
            tv_alam.setText(instansiItems.get(i).getAlamatInstansi());
            tv_latt.setText(instansiItems.get(i).getLat());
            tv_longg1.setText(instansiItems.get(i).getLong());
            open_D.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
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
            });
            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //id = instansiItems.get(i).getId();
                    //idkab = instansiItems.get(i).getIdKabupaten();
                    //namakab = instansiItems.get(i).getNamaKabupaten();
                    //jenisins = instansiItems.get(i).getJenisInstansi();
                    //namains = instansiItems.get(i).getNamaInstansi();
                    //noins = instansiItems.get(i).getNomorInstansi();
                    ///alamat = instansiItems.get(i).getAlamatInstansi();
                    //lat = instansiItems.get(i).getLat()
                    //longg = instansiItems.get(i).getLong();
                    final DataInstansi dataInstansi = new DataInstansi();
                    dataInstansi.setId(instansiItems.get(i).getId());
                    dataInstansi.setIdKabupaten(idkab);
                    dataInstansi.setNamaKabupaten(namakab);
                    dataInstansi.setJenisInstansi(instansiItems.get(i).getJenisInstansi());
                    dataInstansi.setNamaInstansi(instansiItems.get(i).getNamaInstansi());
                    dataInstansi.setNomorInstansi(instansiItems.get(i).getNomorInstansi());
                    dataInstansi.setAlamatInstansi(instansiItems.get(i).getAlamatInstansi());
                    dataInstansi.setLat(instansiItems.get(i).getLat());
                    new InsertData(appDatabase,dataInstansi).execute();
                }
            });
        }
    }
    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private DataInstansi dataInstansi;

        public InsertData(AppDatabase database, DataInstansi dataInstansi) {
            this.database = database;
            this.dataInstansi = dataInstansi;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataInstansi);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();

        }

    }
}
