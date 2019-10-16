package com.example.effortmanagement.contract;

public interface ApproveEffortContract {
    interface Presenter{
        void updateApproveEffort(int effortID, String token);
    }

    interface View{
        void updateApproveEffortSuccess(String message);
        void updateApproveEffortFailure(String message);
    }
}
