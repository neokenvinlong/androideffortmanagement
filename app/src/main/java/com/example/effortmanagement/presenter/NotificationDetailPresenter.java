package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.NotificationDetailContract;
import com.example.effortmanagement.model.dto.NotificationDetailDTO;
import com.example.effortmanagement.networking.API.NotificationDetailService;
import com.example.effortmanagement.networking.NetworkingUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationDetailPresenter implements NotificationDetailContract.Presenter {
    private NotificationDetailContract.View mView;

    public void setmView(NotificationDetailContract.View mView) {
        this.mView = mView;
    }

    NotificationDetailService  notificationDetailService = NetworkingUtils.getNotificationDetailApiInstance();

    @Override
    public void getNotificationInfo(String token) {
        Call<List<NotificationDetailDTO>> call = notificationDetailService.getListNotification("Bearer "+token);
        call.enqueue(new Callback<List<NotificationDetailDTO>>() {
            @Override
            public void onResponse(Call<List<NotificationDetailDTO>> call, Response<List<NotificationDetailDTO>> response) {
                try{
                    if(response.isSuccessful()){
                        mView.getNotificationInfoSuccess(response.body());
                    }else{
                        mView.getNotificationInfoFailure("No Info");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<NotificationDetailDTO>> call, Throwable t) {
                mView.getNotificationInfoFailure("No Info");
            }
        });
    }
}
