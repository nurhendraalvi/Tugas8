package com.example.project.view.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;

public class CreateAccount extends AppCompatActivity {
    EditText ET1, ET2, ET3;
    Button btn_create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ET1 = findViewById(R.id.name);
        ET2 = findViewById(R.id.email);
        ET3 = findViewById(R.id.password);
    }
}
