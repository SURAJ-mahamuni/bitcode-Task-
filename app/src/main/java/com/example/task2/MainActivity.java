package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText username,password1,phone;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initListener() {
        login.setOnClickListener(this);
    }

    private void initView() {
        username = findViewById(R.id.username);
        password1 = findViewById(R.id.password1);
        phone = findViewById(R.id.phone);
        login = findViewById(R.id.login);
    }

    @Override
    public void onClick(View view) {
        if(username.getText().toString().equals("suraj") && password1.getText().toString().equals("suraj123")){
            Intent intent = new Intent(MainActivity.this,Convert_activity.class);
            intent.putExtra("userN",username.getText().toString());
            intent.putExtra("phone_",phone.getText().toString());
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this,"Put Valid Username & Password",Toast.LENGTH_SHORT).show();
        }

    }
}