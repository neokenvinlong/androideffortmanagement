package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.dto.TaskCreDTO;

public interface TaskCreContract {
    interface Present{
        void getTaskName(TaskCreDTO dto,String token);
    }
    interface View{
        void getTaskNameSuccess(TaskCreDTO taskCreDTO);
        void getTaskNameFailure(String message);
    }

}