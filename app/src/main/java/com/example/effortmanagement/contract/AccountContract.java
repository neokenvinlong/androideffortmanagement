package com.example.effortmanagement.contract;

public interface AccountContract {
    interface View{
        void init();

        void doLogin(String name, String password);

        boolean checkLogin(String name, String password);
    }

    interface Presenter{
        void start();
    }
}
