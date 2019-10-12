package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.TaskEffortContract;
import com.example.effortmanagement.model.dto.TaskEffortDTO;
import com.example.effortmanagement.networking.API.TaskEffortService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskEffortPresenter implements TaskEffortContract.Presenter {
    TaskEffortContract.View mView;

    public void setmView(TaskEffortContract.View mView) {
        this.mView = mView;
    }

    TaskEffortService taskEffortService = NetworkingUtils.getTaskEffortApiInstance();

    @Override
    public void getTaskEffortChart(int projectID, String token) {
        Call<List<TaskEffortDTO>> call = taskEffortService.getTaskEffort(projectID, "Bearer "+token);
        call.enqueue(new Callback<List<TaskEffortDTO>>() {
            @Override
            public void onResponse(Call<List<TaskEffortDTO>> call, Response<List<TaskEffortDTO>> response) {
                try{
                    if(response.isSuccessful()){
                        mView.getTaskEffortChartSuccess(response.body());
                    }else {
                        mView.getTaskEffortChartFailure("No Info");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<TaskEffortDTO>> call, Throwable t) {
                mView.getTaskEffortChartFailure("No Info");
            }
        });
//        call.enqueue(new Callback<TaskEffortDTO>() {
//            @Override
//            public void onResponse(Call<TaskEffortDTO> call, Response<TaskEffortDTO> response) {
//                try{
//                    if(response.isSuccessful()){
//                        mView.getTaskEffortChartSuccess(response.body());
//                    }else {
//                        mView.getTaskEffortChartFailure("No Info");
//                    }
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TaskEffortDTO> call, Throwable t) {
//                mView.getTaskEffortChartFailure("No Info");
//            }
//        });
    }
}
