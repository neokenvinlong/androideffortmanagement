package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.EmployeeTaskDetailContract;
import com.example.effortmanagement.model.dto.EmployeeTaskDetailDTO;
import com.example.effortmanagement.networking.API.EmployeeTaskDetailService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeTaskDetailPresenter implements EmployeeTaskDetailContract.Presenter {

    EmployeeTaskDetailContract.View view;

    public void setView(EmployeeTaskDetailContract.View view) {
        this.view = view;
    }

    EmployeeTaskDetailService employeeTaskDetailService = NetworkingUtils.getInfoOfTaskByTaskIdInstance();

    @Override
    public void getInfoOfTaskByTaskId(int task_id, String token) {
        Call<EmployeeTaskDetailDTO> call = employeeTaskDetailService.getInfoOfTaskByTaskId(task_id, "Bearer " + token);
        call.enqueue(new Callback<EmployeeTaskDetailDTO>() {
            @Override
            public void onResponse(Call<EmployeeTaskDetailDTO> call, Response<EmployeeTaskDetailDTO> response) {
                try {
                    if (response.isSuccessful()) {
                        EmployeeTaskDetailDTO employeeTaskDetailDTO = response.body();
                        view.getInfoOfTaskByTaskIdSuccess(employeeTaskDetailDTO);
                    } else {
                        view.getInfoOfTaskByTaskIdFailure("No Info");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<EmployeeTaskDetailDTO> call, Throwable t) {
                view.getInfoOfTaskByTaskIdFailure("No Info");
            }
        });
    }
}


