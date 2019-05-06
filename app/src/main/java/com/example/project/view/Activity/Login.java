package com.example.project.view.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.Presenter.LoginMainView;
import com.example.project.Presenter.LoginPresenter;
import com.example.project.R;
import com.example.project.connection.Login.LoginService;
import com.example.project.model.InstansiItem;
import com.example.project.model.login.getAll.GetAllUserResponse;
import com.example.project.model.login.getUser.GetUserResponse;
import com.example.project.model.login.login_user.LoginResponse;

import java.util.List;

public class Login extends AppCompatActivity implements LoginMainView {
    private LoginResponse loginResponses;
    LoginPresenter loginPresenter;
    EditText username, password;
    Button login, buat_akun;
    String user, pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean login_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.tv_1);
        password = findViewById(R.id.tv_2);
        login = findViewById(R.id.btn);
        buat_akun = findViewById(R.id.buat);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek_login();
                //Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                //startActivity(intent);
            }
        });
        login_save = sharedPreferences.getBoolean("login_Save", false);
        if (login_save == true){
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
        }
        buat_akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    public void cek_login() {
        loginPresenter = new LoginPresenter(this);
       //user = username.getText().toString();
      // pass = password.getText().toString();
        //user = loginResponses.getToken();
        loginPresenter.login(username.getText().toString(), password.getText().toString());
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);

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
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {

    }

    @Override
    public void getSuccess2(LoginResponse login_item) {
        loginResponses = login_item;
        editor.putBoolean("login_save", true);
        editor.putString("key", loginResponses.getToken());
    }
}
