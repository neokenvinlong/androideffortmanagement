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

public class LoginActivity extends AppCompatActivity implements AccountContract.View, RoleContract.View{
    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    private AccountPresenter accountPresenter;
    private RolePresenter rolePresenter;

    private String roleT;
    private String tokenT;
    public static  String tokens;
    private String nameT;

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
        tokenT = token;
        tokens = token;
        this.rolePresenter.getAccountRole(this.edtUsername.getText().toString(), token);
    }

    @Override
    public void loginFailure(String message) {
        Toast.makeText(this, "Login Failure!!!", Toast.LENGTH_SHORT).show();
    }

    private boolean checkLogin(String name, String password) {
        boolean isValid = true;
        if (name.equals("")) {
            edtUsername.setError("Username is required !");
            isValid = false;
        }
        if (password.equals("")) {
            edtPassword.setError("Password is required !");
            isValid = false;
        } else if(password.length() < 6){
            edtPassword.setError("Enter password >5 characters");
            isValid = false;
        }
        return isValid;
    }

    @Override
    public void getAccountRoleSuccess(String role) {
        //System.out.println("Role name: " + role);
        roleT = role;
        switch (role) {
            case "ROLE_PM":
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("account",nameT);
                intent.putExtra("token",tokenT);
                startActivity(intent);

                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                break;
            case "ROLE_EMPLOYEE":
                Intent intent1 = new Intent(getApplicationContext(), EmployeeActivity.class);
                intent1.putExtra("account",nameT);
                intent1.putExtra("token",tokenT);
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
        nameT = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        //validate
        if (checkLogin(nameT, password)) {
            try {
                accountPresenter.doLogin(nameT, password);
//                rolePresenter.getAccountRole(username, this.roleT);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

