package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.ProjectByPMDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ProjectByPMService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("projects/project/employee/{id}")
    Call<List<ProjectByPMDTO>> getProjectInfoByPM(@Path("id") int id, @Header("Authorization") String auth);
}
