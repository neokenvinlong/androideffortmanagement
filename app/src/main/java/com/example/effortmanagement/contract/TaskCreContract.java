package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.TaskCreDTO;

public interface TaskCreContract {
    interface Present{
        void getTaskName(TaskCreDTO dto,String token);
    }
    interface View{
        void getTaskNameSuccess(String message);
        void getTaskNameFailure(String message);
    }

}