package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.TaskContract;
import com.example.effortmanagement.model.Task;
import com.example.effortmanagement.networking.API.TaskService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskPresenter implements TaskContract.Presenter {
    private TaskContract.View mView;

    public void setmView(TaskContract.View mView) {
        this.mView = mView;
    }
    TaskService taskService = NetworkingUtils.getTaskApiInstance();

    @Override
    public void getTaskInfo(int projectId, String token){
        Call<List<Task>> call = taskService.getProjectInfoByPM(projectId,"Bearer "+token);
        call.enqueue(new Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                try{
                    if(response.isSuccessful()){
                        List<Task> tasks = response.body();
                        mView.getTaskInfoSuccess(tasks);
                    }else{
                        mView.getTaskInfoFailure("No Info");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {
                mView.getTaskInfoFailure("No Info");
            }
        });
    }

}
