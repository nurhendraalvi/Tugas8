package com.example.project.view.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project.Presenter.MainPresenter;
import com.example.project.Presenter.MainView;
import com.example.project.R;
import com.example.project.adapter.Adapter;
import com.example.project.model.InstansiItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements MainView {
    private RecyclerView A;
    private Adapter adapter;
    private MainPresenter mainPresenter;
    //private String institusi = "http://dev.farizdotid.com/api/instansi/semuainstansi";
    View item;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        item = inflater.inflate(R.layout.fragment_home, container, false);
        return item;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        A = item.findViewById(R.id.rec_artikel);
        mainPresenter = new MainPresenter(getContext(), this);
        mainPresenter.loadInstitusi();
    }

    @Override
    public void onSucces(List<InstansiItem> instansiItems) {
        adapter = new Adapter(getContext(), instansiItems);
        A.setLayoutManager(new LinearLayoutManager(getContext()));
        A.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(), failureMessage, Toast.LENGTH_SHORT).show();
    }
}
