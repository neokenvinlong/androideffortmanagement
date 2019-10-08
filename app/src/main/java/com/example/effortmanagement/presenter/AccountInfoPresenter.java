package com.example.effortmanagement.presenter;

import com.example.effortmanagement.contract.AccountInfoContract;
import com.example.effortmanagement.model.dto.AccountInfoDTO;
import com.example.effortmanagement.networking.API.AccountInfoService;
import com.example.effortmanagement.networking.NetworkingUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountInfoPresenter implements AccountInfoContract.Presenter {
    private  AccountInfoContract.View mView;


    public void setmView(AccountInfoContract.View mView) {
        this.mView = mView;
    }

    AccountInfoService accountInfoService = NetworkingUtils.getInfoByAccountApiInstance();

    @Override
    public void getAccountInfo(String accountName, String token) {
        Call<AccountInfoDTO> call = accountInfoService.getInfoByAccountName(accountName,"Bearer " + token);
        call.enqueue(new Callback<AccountInfoDTO>() {
            @Override
            public void onResponse(Call<AccountInfoDTO> call, Response<AccountInfoDTO> response) {
                try {
                    if (response.isSuccessful()) {
                        AccountInfoDTO dto = response.body();
                        mView.getAccountInfoSuccess(dto);
                    } else {
                        mView.getAccountInfoFailure("No Info");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AccountInfoDTO> call, Throwable t) {
                mView.getAccountInfoFailure("No Info");
            }
        });
    }
}
