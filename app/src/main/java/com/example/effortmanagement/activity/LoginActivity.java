package com.example.effortmanagement.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.effortmanagement.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //goi act main
                if((username.equals("thanhnv"))&&(password.equals("12345678"))){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                }
                else if(!username.isEmpty() && !password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Login failed", Toast.LENGTH_SHORT).show();
                }
                else if(username.isEmpty()){
                    edtUsername.setError("Enter username");
                }
                else if(password.isEmpty()){
                    edtPassword.setError("Enter password");
                }
                else if(password!=null && password.length() <= 7){
                    edtPassword.setError("Enter password >7 characters");
                }
            }
        });
    }

}
