package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TaskService {
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("tasks/task/list/{id}")
    Call<List<Task>> getProjectInfoByPM(@Path("id") int id, @Header("Authorization") String auth);
}
