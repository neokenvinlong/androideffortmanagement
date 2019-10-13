package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.TaskEmpEffortDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TaskEmpEffortService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("reports/report/employee/{emp_id}")
    Call<List<TaskEmpEffortDTO>> getTaskEmpEffort(@Path("emp_id") int employeeID, @Header("Authorization") String auth);
}
