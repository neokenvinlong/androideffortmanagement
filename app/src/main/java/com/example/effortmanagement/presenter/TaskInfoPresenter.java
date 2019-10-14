package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.TaskInfoContract;
import com.example.effortmanagement.model.dto.TaskInfoDTO;
import com.example.effortmanagement.networking.API.TaskInfoService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskInfoPresenter implements TaskInfoContract.Presenter {
    TaskInfoContract.View mView;

    public void setmView(TaskInfoContract.View mView) {
        this.mView = mView;
    }

    TaskInfoService taskInfoService = NetworkingUtils.getTaskInfoApiInstance();

    @Override
    public void getTaskInfo(int taskID, String token) {
        Call<TaskInfoDTO> call = taskInfoService.getTaskInfo(taskID, "Bearer "+token);
        call.enqueue(new Callback<TaskInfoDTO>() {
            @Override
            public void onResponse(Call<TaskInfoDTO> call, Response<TaskInfoDTO> response) {
                try{
                    if(response.isSuccessful()){
                        mView.getTaskInfoSuccess(response.body());
                    }else{
                        mView.getTaskInfoFailure("No Info");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TaskInfoDTO> call, Throwable t) {
                mView.getTaskInfoFailure("No Info");
            }
        });
    }
}
