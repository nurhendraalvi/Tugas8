package com.example.project.view.Fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project.Presenter.LoginMainView;
import com.example.project.Presenter.LoginPresenter;
import com.example.project.Presenter.MainView;
import com.example.project.R;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;
import com.example.project.view.Activity.Login;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Akun extends Fragment implements LoginMainView {
    TextView TV_1, TV_2;
    Button button, btn_edit;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    LoginPresenter loginPresenter;
    LoginResponse loginResponse;
    List<GetUserResponse> getUserResponset;
    String login, token, nama;
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
        btn_edit = view.findViewById(R.id.btn_1);
        button = view.findViewById(R.id.btn_2);
        TV_1 = view.findViewById(R.id.nama);
        TV_2 = view.findViewById(R.id.email);
        pref = getContext().getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = pref.edit();
        token = pref.getString("key", "");
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getUsers(token);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear().apply();

                startActivity(new Intent(getContext(), Login.class));
                getActivity().finish();

            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_user(token, nama);
            }
        });
    }


    @Override
    public void getSuccess(List<GetUserResponse> list) {
        TV_1.setText(list.get(0).getName());
        TV_2.setText(list.get(0).getEmail());
        nama = TV_1.getText().toString();
    }

    @Override
    public void setToast(String message) {

    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void onFailure(String failureMessage) {

    }

    @Override
    public void getSuccess2(LoginResponse listItem) {

    }
    private void edit_user(final String id, final String name) {
        LayoutInflater factory = LayoutInflater.from(getContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Edit Akun");
        final View textEntryView = factory.inflate(R.layout.text_entry, null);
        final EditText edtName = (EditText)
                textEntryView.findViewById(R.id.edt_name_edit);
        final String token = id;
        edtName.setText(name, TextView.BufferType.EDITABLE);
        builder.setView(textEntryView);
        builder.setTitle("Edit Akun");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loginPresenter.updateUser(id, edtName.getText().toString());
            }
        });
        builder.setNegativeButton("Tidak", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }
}
