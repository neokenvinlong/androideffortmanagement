package com.example.effortmanagement.presenter;

import android.content.Intent;
import android.widget.Toast;

import com.example.effortmanagement.contract.RoleContract;
import com.example.effortmanagement.model.dto.LoginRoleAccountDTO;
import com.example.effortmanagement.networking.API.RoleService;
import com.example.effortmanagement.networking.NetworkingUtils;
import com.example.effortmanagement.view.EmployeeActivity;
import com.example.effortmanagement.view.LoginActivity;
import com.example.effortmanagement.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RolePresenter implements RoleContract.Presenter {

    RoleContract.View view;

    public void setView(RoleContract.View view) {
        this.view = view;
    }

    @Override
    public void getAccountRole(String username, final String token) {
        RoleService roleService = NetworkingUtils.getRoleApiInstance();
        Call<LoginRoleAccountDTO> callAccount = roleService.checkRole(username, "Bearer " + token);
        callAccount.enqueue(new Callback<LoginRoleAccountDTO>() {
            @Override
            public void onResponse(Call<LoginRoleAccountDTO> call, Response<LoginRoleAccountDTO> response) {
                if (response.isSuccessful()) {
                    view.getAccountRoleSuccess(response.body().getRole());
                }else{
                    System.out.println("failure first!!!");
                }
            }

            @Override
            public void onFailure(Call<LoginRoleAccountDTO> call, Throwable t) {
                System.out.println("Get role failure");
            }
        });
    }
}
