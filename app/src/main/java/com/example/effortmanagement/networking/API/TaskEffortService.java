package com.example.effortmanagement.networking.API;

import com.example.effortmanagement.model.dto.TaskEffortDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface TaskEffortService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("reports/report/task/{project_id}")
    Call<List<TaskEffortDTO>> getTaskEffort(@Path("project_id") int projectId, @Header("Authorization") String auth);

}
