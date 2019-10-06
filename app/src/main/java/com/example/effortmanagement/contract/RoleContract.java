package com.example.effortmanagement.contract;

public interface RoleContract
{
    interface Presenter{
        void getAccountRole(String username, String token);

    }
    interface View{

        void getAccountRoleSuccess(String role);
        void getAccountRoleFailure(String message);
    }
}
