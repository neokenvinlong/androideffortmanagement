package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.NotificationDetailDTO;

import java.util.List;

public interface NotificationDetailContract {
    interface Presenter{
        void getNotificationInfo(String token);
    }
    interface View{
        void getNotificationInfoSuccess(List<NotificationDetailDTO> listDTO);
        void getNotificationInfoFailure(String message);
    }
}
