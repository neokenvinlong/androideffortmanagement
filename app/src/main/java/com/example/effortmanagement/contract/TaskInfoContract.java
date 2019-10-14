package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.TaskInfoDTO;

public interface TaskInfoContract {
    interface Presenter{
        void getTaskInfo(int taskID, String token);
    }
    interface View{
        void getTaskInfoSuccess(TaskInfoDTO dto);
        void getTaskInfoFailure(String message);
    }
}
