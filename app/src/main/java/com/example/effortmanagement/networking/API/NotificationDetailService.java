package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.NotificationDetailDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface NotificationDetailService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("efforts/effort/approve/project")
    Call<List<NotificationDetailDTO>> getListNotification(@Header("Authorization") String auth);
}
