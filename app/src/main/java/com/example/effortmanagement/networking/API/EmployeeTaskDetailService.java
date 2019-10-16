package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.EmployeeTaskDetailDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface EmployeeTaskDetailService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("tasks/task/info/{id}")
    Call<EmployeeTaskDetailDTO> getInfoOfTaskByTaskId(@Path("id") int task_id, @Header("Authorization") String auth);
}
