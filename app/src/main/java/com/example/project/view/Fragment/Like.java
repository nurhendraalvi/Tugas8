package com.example.project.view.Fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project.Presenter.MainPresenter;
import com.example.project.Presenter.PresenterDAO;
import com.example.project.R;
import com.example.project.adapter.Adapter;
import com.example.project.adapter.LikeAdapter;
import com.example.project.entity.AppDatabase;
import com.example.project.entity.DataInstansi;
import com.example.project.view.Activity.Main2Activity;
import com.example.project.view.MainContact;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Like extends Fragment implements MainContact.hapus {
    private RecyclerView A;
    private Adapter adapter;
    private AppDatabase appDatabase;
    private PresenterDAO presenterDAO;
    private LikeAdapter likeadapter;
    Context context;

    public Like() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        A = view.findViewById(R.id.rec_artikel);
        //mainPresenter = new PresenterDAO(context, this);
        //mainPresenter.loadInstitusi();
        presenterDAO = new PresenterDAO(this);
        A.setLayoutManager(new LinearLayoutManager(context));
        appDatabase = AppDatabase.iniDb(getContext());
        readData(appDatabase);
    }
    public void readData(AppDatabase database) {
        List list;
        list = database.dao().getData();
        //view.getData(list);
        likeadapter = new LikeAdapter(context, list, this);
        A.setAdapter(likeadapter);
    }

    @Override
    public void sukses() {
        Toast.makeText(getContext(), "unlike", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getContext(), Main2Activity.class));
    }

    @Override
    public void deleteData(final DataInstansi item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // resetForm();
                        presenterDAO.deleteData(appDatabase, item);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    }

