package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.TaskEmpEffortContract;
import com.example.effortmanagement.model.dto.TaskEmpEffortDTO;
import com.example.effortmanagement.networking.API.TaskEmpEffortService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskEmpEffortPresenter implements TaskEmpEffortContract.Presenter {
    TaskEmpEffortContract.View mView;

    public void setmView(TaskEmpEffortContract.View mView) {
        this.mView = mView;
    }

    TaskEmpEffortService taskEmpEffortService = NetworkingUtils.getTaskEmpEffortApiInstance();

    @Override
    public void getTaskEmpEffortChart(int employeeID, String token) {
        Call<List<TaskEmpEffortDTO>> call = taskEmpEffortService.getTaskEmpEffort(employeeID,"Bearer "+token);
        call.enqueue(new Callback<List<TaskEmpEffortDTO>>() {
            @Override
            public void onResponse(Call<List<TaskEmpEffortDTO>> call, Response<List<TaskEmpEffortDTO>> response) {
                try{
                    if(response.isSuccessful()){
                        System.out.println("1234");
                        mView.getTaskEmpEffortChartSuccess(response.body());
                    }else {
                        mView.getTaskEmpEffortChartFailure("No Info 1");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<TaskEmpEffortDTO>> call, Throwable t) {
                mView.getTaskEmpEffortChartFailure("No Info");
            }
        });
    }
}
