package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.EmployeeProDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface EmployeeProService {
    @GET("employees/employee/project/{project_id}")
    Call<List<EmployeeProDTO>> getEmployeeProject(@Path("project_id") int projectID, @Header("Authorization") String auth);
}
