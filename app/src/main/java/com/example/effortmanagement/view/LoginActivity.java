package com.example.effortmanagement.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.AccountContract;

import com.example.effortmanagement.model.Account;
import com.example.effortmanagement.model.dto.LoginAccountDTO;
import com.example.effortmanagement.model.Token;
import com.example.effortmanagement.model.dto.LoginRoleAccountDTO;
import com.example.effortmanagement.networking.API.AccountService;
import com.example.effortmanagement.networking.API.RoleService;
import com.example.effortmanagement.networking.NetworkingUtils;
import com.example.effortmanagement.presenter.AccountPresenter;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements AccountContract.View {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    AccountPresenter mPresenter;
    AccountService accountService;
    RoleService roleService;
    public String token;
    public static String roleT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mPresenter = new AccountPresenter();
        mPresenter.setmView(this);
    }

    @Override
    public void init() {
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        accountService = NetworkingUtils.getUserApiInstance();
        roleService = NetworkingUtils.getRoleApiInstance();

        //click button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                //validate
                if (checkLogin(username, password)) {
                    //dispatcherLogin(username,password);
                    try {
                        doLogin(username, password);
                        getRoleAccount(username);
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });

    }

//    public void dispatcherLogin(String username, String password) {
//        String tokenLogin = doLogin(username, password);
//        String role = getRoleAccount(username);
//        if (tokenLogin != null) {
//            if (role == "ROLE_PM") {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//            } else if (role == "ROLE_EMPLOYEE") {
//                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
//                startActivity(intent);
//                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    public String doLogin(final String name, String password) {
        LoginAccountDTO dto = new LoginAccountDTO();
        dto.setPassword(password);
        dto.setUsername(name);

        Call<Token> call = accountService.login(dto);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()) {
                    Token tokenTemp = response.body();
                    token = tokenTemp.getTokens();
//                    if (!token.isEmpty()) {
//                        if (roleT == "ROLE_PM") {
//                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                            startActivity(intent);
//                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//                        } else if (roleT == "ROLE_EMPLOYEE") {
//                            Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
//                            startActivity(intent);
//                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
//                    }
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "bbbbbbbbbb", Toast.LENGTH_SHORT).show();
            }
        });
        return token;
    }

    @Override
    public boolean checkLogin(String name, String password) {
        if (name.equals("")) {
            edtUsername.setError("Enter username");
            return false;
        } else if (password.equals("")) {
            edtPassword.setError("Enter password");
            return false;
        } else if (!password.equals("") && password.length() < 6) {
            edtPassword.setError("Enter password >5 characters");
            return false;
        }
        return true;
    }

    @Override
    public void getRoleAccount(String name) {
//        try {
//            Call<LoginRoleAccountDTO> callAccount = accountService.checkRole(name, "Bearer " + token);
//            callAccount.enqueue(new Callback<LoginRoleAccountDTO>() {
//                @Override
//                public void onResponse(Call<LoginRoleAccountDTO> call, Response<LoginRoleAccountDTO> response) {
//                    if (response.isSuccessful()) {
//                        LoginRoleAccountDTO dto = response.body();
//                        roleT = dto.getRole();
//                    }
//                }
//                @Override
//                public void onFailure(Call<LoginRoleAccountDTO> call, Throwable t) {
//                    System.out.println(t.getMessage());
//                }
//            });
//            Log.d("role la ngoai", roleT);
//            return roleT;
//        } catch (Exception ex) {
//            return null;
//        }
        Call<LoginRoleAccountDTO> callAccount = roleService.checkRole(name, "Bearer " + token);
        callAccount.enqueue(new Callback<LoginRoleAccountDTO>() {
            @Override
            public void onResponse(Call<LoginRoleAccountDTO> call, Response<LoginRoleAccountDTO> response) {
                if (response.isSuccessful()) {
                    LoginRoleAccountDTO dto = response.body();
                    roleT = dto.getRole();
//                    Log.d("Role la ",roleT);
                    switch (roleT) {
                        case "ROLE_PM":
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            break;
                        case "ROLE_EMPLOYEE":
                            Intent intent1 = new Intent(getApplicationContext(), EmployeeActivity.class);
                            startActivity(intent1);
                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(LoginActivity.this, "Login fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginRoleAccountDTO> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "aaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
