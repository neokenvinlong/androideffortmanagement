package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.EmployeeUpdateEffortContract;
import com.example.effortmanagement.model.dto.EmployeeUpdateEffortDTO;
import com.example.effortmanagement.networking.API.EmployeeUpdateEffortService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeUpdateEffortPresenter implements EmployeeUpdateEffortContract.Presenter {

    EmployeeUpdateEffortContract.View view;

    public void setView(EmployeeUpdateEffortContract.View view) {
        this.view = view;
    }

    EmployeeUpdateEffortService employeeUpdateEffortService = NetworkingUtils.updateEffortInstance();

    @Override
    public void updateEffort(EmployeeUpdateEffortDTO employeeUpdateEffortDTO, String token) {
        Call<EmployeeUpdateEffortDTO> call = employeeUpdateEffortService.updateEffortByTaskId(employeeUpdateEffortDTO, "Bearer "+token);
        call.enqueue(new Callback<EmployeeUpdateEffortDTO>() {
            @Override
            public void onResponse(Call<EmployeeUpdateEffortDTO> call, Response<EmployeeUpdateEffortDTO> response) {
                try {
                    if (response.isSuccessful()){
                        view.updateEffortSuccess("Update successful");
                    }else {
                        view.updateEffortFailure("Update failure");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<EmployeeUpdateEffortDTO> call, Throwable t) {
                view.updateEffortFailure("Update successful");
            }
        });
    }
}
