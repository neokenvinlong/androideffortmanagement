package com.example.effortmanagement.presenter;

import android.widget.Toast;

import com.example.effortmanagement.contract.AccountContract;
import com.example.effortmanagement.model.Token;
import com.example.effortmanagement.model.dto.LoginAccountDTO;
import com.example.effortmanagement.networking.API.AccountService;
import com.example.effortmanagement.networking.NetworkingUtils;
import com.example.effortmanagement.view.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountPresenter implements AccountContract.Presenter {
    private AccountContract.View mView;

    public void setmView(AccountContract.View mView) {
        this.mView = mView;
    }

    AccountService accountService = NetworkingUtils.getUserApiInstance();


    @Override
    public void doLogin(String name, String password) {
        LoginAccountDTO dto = new LoginAccountDTO();
        dto.setPassword(password);
        dto.setUsername(name);

        Call<Token> call = accountService.login(dto);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()) {
                    mView.loginSuccess(response.body().getTokens());

                }else{
                    mView.loginFailure("Login failure");
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                mView.loginFailure("Login failure");
            }
        });
    }

//    @Override
//    public void loadAccounts() {
//        Account account = new Account();
//        AccountService accountService = NetworkingUtils.getUserApiInstance();
//        Call<Account> call = accountService.login(account.getName(),account.getPassword());
//        call.enqueue(new Callback<Account>() {
//            @Override
//            public void onResponse(Call<Account> call, Response<Account> response) {
//                mView.checkLogin(account.getName(),account.getPassword());
//            }
//
//            @Override
//            public void onFailure(Call<Account> call, Throwable t) {
//
//            }
//        });
//    }
}
