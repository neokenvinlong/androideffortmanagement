package com.example.effortmanagement.presenter;

import android.widget.Toast;

import com.example.effortmanagement.contract.TaskCreContract;
import com.example.effortmanagement.model.dto.TaskCreDTO;
import com.example.effortmanagement.networking.API.TaskCreService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskCrePresenter implements TaskCreContract.Present {
    TaskCreContract.View mView;

    public void setmView(TaskCreContract.View mView) {
        this.mView = mView;
    }

    TaskCreService taskCreService = NetworkingUtils.getTaskCreApiInstance();

    @Override
    public void getTaskName(TaskCreDTO dto, String token) {
        Call<TaskCreDTO> call = taskCreService.getTaskCre(dto,"Bearer "+token);
        call.enqueue(new Callback<TaskCreDTO>() {
            @Override
            public void onResponse(Call<TaskCreDTO> call, Response<TaskCreDTO> response) {
                try{
                    if(response.isSuccessful()){
                        TaskCreDTO dto = response.body();
                        mView.getTaskNameSuccess(dto);
                    }else{
                        mView.getTaskNameFailure("No Info");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TaskCreDTO> call, Throwable t) {

            }
        });
    }
}
