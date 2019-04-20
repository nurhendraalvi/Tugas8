package com.example.project.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project.R;

public class Detail_Item extends AppCompatActivity {
    private TextView tv_id;
    private TextView tv_idKab;
    private TextView tv_namaKab;
    private TextView tv_Jeniss;
    private TextView tv_nama;
    private TextView tv_no;
    private TextView tv_alam;
    private TextView tv_latt;
    private TextView tv_longg1;
    private String a,b,c,d,e,f,g,h,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__item);
        tv_id = findViewById(R.id.tv_id);
        tv_idKab = findViewById(R.id.tv_id_kab);
        tv_namaKab = findViewById(R.id.tv_nama_kab);
        tv_Jeniss = findViewById(R.id.tv_jenis);
        tv_nama = findViewById(R.id.tv_nama_ins);
        tv_no = findViewById(R.id.tv_no_ins);
        tv_alam = findViewById(R.id.tv_alamat);
        tv_latt = findViewById(R.id.tv_lat);
        tv_longg1 = findViewById(R.id.tv_long);

        a = getIntent().getStringExtra("id");
        b = getIntent().getStringExtra("id_kab");
        c = getIntent().getStringExtra("nm_kab");
        d = getIntent().getStringExtra("jenis");
        e = getIntent().getStringExtra("nm_ins");
        f = getIntent().getStringExtra("no_ins");
        g = getIntent().getStringExtra("alamat");
        h = getIntent().getStringExtra("lat");
        i = getIntent().getStringExtra("long");

        tv_id.setText(a);
        tv_idKab.setText(b);
        tv_namaKab.setText(c);
        tv_Jeniss.setText(d);
        tv_nama.setText(e);
        tv_no.setText(f);
        tv_alam.setText(g);
        tv_latt.setText(h);
        tv_longg1.setText(i);
    }
}
