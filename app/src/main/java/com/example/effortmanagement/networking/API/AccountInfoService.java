package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.AccountInfoDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface AccountInfoService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("employees/employee/account/{username}")
    Call<AccountInfoDTO> getInfoByAccountName(@Path("username") String name, @Header("Authorization") String auth);
}
