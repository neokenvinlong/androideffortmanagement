package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.TaskUpdateContract;
import com.example.effortmanagement.model.dto.TaskCreDTO;
import com.example.effortmanagement.networking.API.TaskUpdateService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskUpdatePresenter implements TaskUpdateContract.Presenter {
    TaskUpdateContract.View mView;

    public void setmView(TaskUpdateContract.View mView) {
        this.mView = mView;
    }
    TaskUpdateService taskUpdateService = NetworkingUtils.getTaskUpdateApiInstance();

    @Override
    public void getTaskUpdate(TaskCreDTO dto, String token) {
        Call<TaskCreDTO> call = taskUpdateService.getTaskUpdate(dto,"Bearer "+token);
        call.enqueue(new Callback<TaskCreDTO>() {
            @Override
            public void onResponse(Call<TaskCreDTO> call, Response<TaskCreDTO> response) {
                try{
                    if(response.isSuccessful()){
                        mView.getTaskUpdateSuccess("Update successfully!");
                    }else{
                        mView.getTaskUpdateFailure("No Info");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TaskCreDTO> call, Throwable t) {
                mView.getTaskUpdateFailure("No Info");
            }
        });
    }
}
