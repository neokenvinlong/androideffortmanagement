package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.EmployeeTaskListDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface EmployeeTaskListService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("tasks/task/employee/{account_name}")
    Call<List<EmployeeTaskListDTO>> getListTaskOfEmployeeByAccountName(@Path("account_name") String account_name, @Header("Authorization") String auth);
}
