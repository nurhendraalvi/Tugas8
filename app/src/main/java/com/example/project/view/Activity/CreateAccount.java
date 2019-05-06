package com.example.project.view.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.Presenter.LoginMainView;
import com.example.project.Presenter.LoginPresenter;
import com.example.project.R;
import com.example.project.model.login.getAll.GetAllUserResponse;
import com.example.project.model.login.login_user.LoginResponse;

public class CreateAccount extends AppCompatActivity implements LoginMainView {
    EditText ET1, ET2, ET3;
    Button btn_create;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ET1 = findViewById(R.id.name);
        ET2 = findViewById(R.id.email);
        ET3 = findViewById(R.id.password);
        btn_create = findViewById(R.id.btn_create);
        loginPresenter = new LoginPresenter(this);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.createAccount(ET1.getText().toString(), ET2.getText().toString(), ET3.getText().toString());
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }

    @Override
    public void getSuccess(GetAllUserResponse list) {

    }

    @Override
    public void setToast(String message) {
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
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
}
