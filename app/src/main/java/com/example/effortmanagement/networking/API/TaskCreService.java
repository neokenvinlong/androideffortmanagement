package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.TaskCreDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TaskCreService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("tasks/task")
    Call<TaskCreDTO> getTaskCre(@Body TaskCreDTO dto, @Header("Authorization") String auth);
}
