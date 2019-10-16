package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.NotificationDetailDTO;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface ApproveEffortService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PATCH("efforts/effort/approve/{id}")
    Call<NotificationDetailDTO> getApproveEffort(@Path("id") int effortID, @Header("Authorization") String auth);
}
