package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.TaskInfoDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TaskInfoService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("tasks/task/info/{id}")
    Call<TaskInfoDTO> getTaskInfo(@Path("id") int taskID, @Header("Authorization") String auth);
}
