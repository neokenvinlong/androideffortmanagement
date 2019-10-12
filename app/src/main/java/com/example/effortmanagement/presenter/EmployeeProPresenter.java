package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.EmployeeProContract;
import com.example.effortmanagement.model.dto.EmployeeProDTO;
import com.example.effortmanagement.model.dto.ProjectByPMDTO;
import com.example.effortmanagement.networking.API.EmployeeProService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeProPresenter implements EmployeeProContract.Presenter {
    EmployeeProContract.View mView;

    public void setmView(EmployeeProContract.View mView) {
        this.mView = mView;
    }

    EmployeeProService employeeProService = NetworkingUtils.getEmployeeProApiInstance();

    @Override
    public void getEmployeeProInfo(int projectId, String token) {
        Call<List<EmployeeProDTO>> call = employeeProService.getEmployeeProject(projectId,"Bearer " + token);
        call.enqueue(new Callback<List<EmployeeProDTO>>() {
            @Override
            public void onResponse(Call<List<EmployeeProDTO>> call, Response<List<EmployeeProDTO>> response) {
                try{
                    if(response.isSuccessful()){
                        List<EmployeeProDTO> list = response.body();
                        mView.getEmployeeProInfoSuccess(list);
                    }else {
                        mView.getEmployeeProInfoFailure("No Info");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeProDTO>> call, Throwable t) {
                mView.getEmployeeProInfoFailure("No Info");
            }
        });
    }
}
