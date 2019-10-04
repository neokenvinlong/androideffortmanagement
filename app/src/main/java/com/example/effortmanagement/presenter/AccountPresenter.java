package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.AccountContract;

public class AccountPresenter implements AccountContract.Presenter {
    private AccountContract.View mView;

    public AccountPresenter(AccountContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
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
