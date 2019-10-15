package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.TaskCreDTO;

public interface TaskUpdateContract {
    interface Presenter{
        void getTaskUpdate(TaskCreDTO dto, String token);
    }
    interface View{
        void getTaskUpdateSuccess(String message);
        void getTaskUpdateFailure(String message);
    }
}
