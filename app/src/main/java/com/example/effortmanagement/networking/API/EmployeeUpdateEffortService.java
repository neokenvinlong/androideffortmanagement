package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.EmployeeUpdateEffortDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

public interface EmployeeUpdateEffortService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PUT("efforts/effort")
    Call<EmployeeUpdateEffortDTO> updateEffortByTaskId (@Body EmployeeUpdateEffortDTO employeeUpdateEffortDTO, @Header("Authorization") String auth);
}
