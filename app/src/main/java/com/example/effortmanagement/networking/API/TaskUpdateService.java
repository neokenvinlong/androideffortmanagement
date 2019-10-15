package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.TaskCreDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

public interface TaskUpdateService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PUT("tasks/task")
    Call<TaskCreDTO> getTaskUpdate(@Body TaskCreDTO dto, @Header("Authorization") String auth);
}
