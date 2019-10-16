package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.ApproveEffortContract;
import com.example.effortmanagement.model.dto.NotificationDetailDTO;
import com.example.effortmanagement.networking.API.ApproveEffortService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApproveEffortPresenter implements ApproveEffortContract.Presenter {

    private ApproveEffortContract.View mView;

    public void setmView(ApproveEffortContract.View mView) {
        this.mView = mView;
    }

    ApproveEffortService approveEffortService = NetworkingUtils.getApproveEffortApiInstance();

    @Override
    public void updateApproveEffort(int effortID, String token) {
        Call<NotificationDetailDTO> call = approveEffortService.getApproveEffort(effortID,"Bearer "+token);
        call.enqueue(new Callback<NotificationDetailDTO>() {
            @Override
            public void onResponse(Call<NotificationDetailDTO> call, Response<NotificationDetailDTO> response) {
                try{
                    if(response.isSuccessful()){
                        mView.updateApproveEffortSuccess("Approved!!");
                    }else{
                        mView.updateApproveEffortFailure("Can't Approved");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<NotificationDetailDTO> call, Throwable t) {
                mView.updateApproveEffortFailure("Can't Approved");
            }
        });
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                try{
//                    if(response.isSuccessful()){
//                        mView.updateApproveEffortSuccess("Approved!!");
//                    }else{
//                        mView.updateApproveEffortFailure("Can't Approved");
//                    }
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                mView.updateApproveEffortFailure("Can't Approved");
//            }
//        });
    }
}
