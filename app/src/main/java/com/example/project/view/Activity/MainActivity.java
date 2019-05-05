package com.example.project.view.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.project.Presenter.MainPresenter;
import com.example.project.Presenter.MainView;
import com.example.project.R;
import com.example.project.adapter.Adapter;
import com.example.project.model.InstansiItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView A;
    private Adapter adapter;
    private MainPresenter mainPresenter;
    //private String institusi = "http://dev.farizdotid.com/api/instansi/semuainstansi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.rec_artikel);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.loadInstitusi();
    }

    @Override
    public void onSucces(List<InstansiItem> instansiItems) {
        adapter = new Adapter(getApplicationContext(), instansiItems);
        A.setLayoutManager(new LinearLayoutManager(this));
        A.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }
}
