package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.EmployeeTaskListContract;
import com.example.effortmanagement.model.dto.EmployeeTaskListDTO;
import com.example.effortmanagement.networking.API.EmployeeTaskListService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeTaskListPresenter implements EmployeeTaskListContract.Presenter {

    EmployeeTaskListContract.View eView;

    public void seteView(EmployeeTaskListContract.View eView) {
        this.eView = eView;
    }

    EmployeeTaskListService employeeTaskListService = NetworkingUtils.getListTaskOfEmployeeByAccountNameInstance();

    @Override
    public void getListTaskOfEmployeeByAccountName(String account_name, String token) {
        Call<List<EmployeeTaskListDTO>> call = employeeTaskListService.getListTaskOfEmployeeByAccountName(account_name, "Bearer "+token);
        call.enqueue(new Callback<List<EmployeeTaskListDTO>>() {
            @Override
            public void onResponse(Call<List<EmployeeTaskListDTO>> call, Response<List<EmployeeTaskListDTO>> response) {
                try{
                    if(response.isSuccessful()){
                        List<EmployeeTaskListDTO> list = response.body();
                        eView.getListTaskOfEmployeeByAccountNameSuccess(list);
                    }else {
                        eView.getListTaskOfEmployeeByAccountNameFailure("No Info");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeTaskListDTO>> call, Throwable t) {
                eView.getListTaskOfEmployeeByAccountNameFailure("No Info");
            }
        });
    }
}
