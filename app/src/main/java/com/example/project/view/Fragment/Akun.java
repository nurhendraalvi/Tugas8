package com.example.project.view.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class Akun extends Fragment {
    TextView TV_1, TV_2;
    Button button;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    LoginResponse loginResponse;
    GetUserResponse getUserResponset;
    String login;
    public Akun() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akun, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.btn_1);
        TV_1 = view.findViewById(R.id.nama);
        TV_2 = view.findViewById(R.id.email);
        pref = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = pref.edit();
        login = pref.getString("key", "");
        TV_1.setText(getUserResponset.getName());
        TV_2.setText(getUserResponset.getEmail());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
