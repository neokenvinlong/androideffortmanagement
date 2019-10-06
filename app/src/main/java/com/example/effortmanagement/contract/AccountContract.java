package com.example.effortmanagement.contract;

public interface AccountContract {
    interface View{
        void init();

        String doLogin(String name, String password);

        boolean checkLogin(String name, String password);

        void getRoleAccount(String name);

    }

    interface Presenter{
        void start();
    }
}
