package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.AccountInfoDTO;

public interface AccountInfoContract {
    interface Presenter{
        void getAccountInfo(String accountName, String token);
    }
    interface View{
        void getAccountInfoSuccess(AccountInfoDTO accountInfoDTO);
        void getAccountInfoFailure(String message);
    }
}
