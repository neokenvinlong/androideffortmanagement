package com.example.effortmanagement.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.AccountContract;
import com.example.effortmanagement.contract.RoleContract;
import com.example.effortmanagement.presenter.AccountPresenter;
import com.example.effortmanagement.presenter.RolePresenter;

public class LoginActivity extends AppCompatActivity implements AccountContract.View, RoleContract.View {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    AccountPresenter accountPresenter;
    RolePresenter rolePresenter;

    private static String roleT;
    private static String tokenT;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

    }

    private void init() {

        accountPresenter = new AccountPresenter();
        accountPresenter.setmView(this);

        rolePresenter = new RolePresenter();
        rolePresenter.setView(this);

    }

    @Override
    public void loginSuccess(String token) {
//        System.out.println("Token:" + token);
//        this.roleT = token;
        tokenT = token;
        this.rolePresenter.getAccountRole(this.edtUsername.getText().toString(), token);
    }

    @Override
    public void loginFailure(String mesage) {
        Toast.makeText(this, "Login Failure!!!", Toast.LENGTH_SHORT).show();
    }

    private boolean checkLogin(String name, String password) {
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
    public void getAccountRoleSuccess(String role) {
        System.out.println("Role name: " + role);
        roleT = role;
        switch (role) {
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

    @Override
    public void getAccountRoleFailure(String message) {
        System.out.println("get role failure!!!");
    }

    public void clickLogIn(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        //validate
        if (checkLogin(username, password)) {
            try {
                accountPresenter.doLogin(username, password);
//                rolePresenter.getAccountRole(username, this.roleT);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }
    }

