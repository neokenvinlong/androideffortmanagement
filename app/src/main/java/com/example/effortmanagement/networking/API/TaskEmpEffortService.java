package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.TaskEmpEffortDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface TaskEmpEffortService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("reports/report/employee")
    Call<List<TaskEmpEffortDTO>> getTaskEmpEffort(@Body int empId, @Header("Authorization") String auth);
}
