package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.LoginAccountDTO;
import com.example.effortmanagement.model.dto.LoginRoleAccountDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RoleService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("me/{account_name}")
    Call<LoginRoleAccountDTO> checkRole(@Path("account_name") String name, @Header("Authorization") String auth);
}
