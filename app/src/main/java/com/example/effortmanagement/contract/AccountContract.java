package com.example.effortmanagement.contract;

public interface AccountContract {
    interface View{

        void loginSuccess(String token);
        void loginFailure(String mesage);

    }

    interface Presenter{
        void doLogin(String name, String password);
    }
}
