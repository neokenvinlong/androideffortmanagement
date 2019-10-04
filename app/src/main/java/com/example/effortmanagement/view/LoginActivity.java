package com.example.effortmanagement.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.AccountContract;
import com.example.effortmanagement.model.dto.LoginAccountDTO;
import com.example.effortmanagement.model.Token;
import com.example.effortmanagement.networking.API.AccountService;
import com.example.effortmanagement.networking.NetworkingUtils;
import com.example.effortmanagement.presenter.AccountPresenter;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements AccountContract.View {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    AccountPresenter mPresenter;
    AccountService accountService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mPresenter = new AccountPresenter(this);
        mPresenter.start();

        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //goi act main
                if((username.equals("thanhnv"))&&(password.equals("12345678"))){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
        });*/
    }

    @Override
    public void init() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        accountService = NetworkingUtils.getUserApiInstance();
        //click button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //validate
                if(checkLogin(username,password)){
                    doLogin(username,password);
                }
            }
        });

    }

    @Override
    public void doLogin(String name, String password) {
        LoginAccountDTO dto = new LoginAccountDTO();
        dto.setPassword(password);
        dto.setUsername(name);
        Call<Token> call = accountService.login(dto);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()){
                    Token token = response.body();
                    if(!token.getTokens().isEmpty()){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this,"Login successful", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(LoginActivity.this, jObjError.getJSONObject("error").getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                System.out.println(t.getMessage());
            }

        });
    }

    @Override
    public boolean checkLogin(String name, String password) {
//        if(!name.equals("") && !password.equals("")){
//            Toast.makeText(LoginActivity.this,"Login failed", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if(name.equals("")){
            edtUsername.setError("Enter username");
            return false;
        }
        else if(password.equals("")){
            edtPassword.setError("Enter password");
            return false;
        }
        else if(!password.equals("") && password.length() <6){
            edtPassword.setError("Enter password >5 characters");
            return false;
        }
        return true;
    }
}
