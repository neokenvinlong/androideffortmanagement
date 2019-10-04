package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.LoginAccountDTO;
import com.example.effortmanagement.model.Token;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AccountService {

    @POST("authenticate")
    Call<Token> login(@Body LoginAccountDTO dto);



}
