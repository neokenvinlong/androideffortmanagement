package com.example.effortmanagement.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.effortmanagement.contract.ProjectInfoContract;
import com.example.effortmanagement.model.dto.ProjectByPMDTO;
import com.example.effortmanagement.networking.API.ProjectByPMService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectInfoPresenter implements ProjectInfoContract.Presenter {
    private ProjectInfoContract.View mView;

    public void setmView(ProjectInfoContract.View mView) {
        this.mView = mView;
    }

    ProjectByPMService projectByPMService = NetworkingUtils.getProjectInfoByPMApiInstance();

    @Override
    public void getProjectInfo(int id, String token) {
        Call<List<ProjectByPMDTO>> call = projectByPMService.getProjectInfoByPM(id,"Bearer "+token);
        call.enqueue(new Callback<List<ProjectByPMDTO>>() {
            @Override
            public void onResponse(Call<List<ProjectByPMDTO>> call, Response<List<ProjectByPMDTO>> response) {
                try{
                    if(response.isSuccessful()){
                        List<ProjectByPMDTO> list = response.body();
                        mView.getProjectInfoSuccess(list);
                    }else {
                        mView.getProjectInfoFailure("No Info");
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<ProjectByPMDTO>> call, Throwable t) {
                mView.getProjectInfoFailure("No info");
            }
        });
    }
}
