package com.example.effortmanagement.contract;

import com.example.effortmanagement.model.Task;

import java.util.List;

public interface TaskContract {
    interface Presenter{
        void getTaskInfo(int projectId, String token);
    }
    interface View{
        void getTaskInfoSuccess(List<Task> tasks);
        void getTaskInfoFailure(String message);
    }
}
