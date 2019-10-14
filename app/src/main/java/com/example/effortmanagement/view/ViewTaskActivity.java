package com.example.effortmanagement.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.TaskInfoContract;
import com.example.effortmanagement.model.dto.TaskInfoDTO;
import com.example.effortmanagement.presenter.EmployeeProPresenter;
import com.example.effortmanagement.presenter.TaskCrePresenter;
import com.example.effortmanagement.presenter.TaskInfoPresenter;

import static com.example.effortmanagement.fragment.TaskListFragment.taskID;
import static com.example.effortmanagement.view.LoginActivity.tokens;

public class ViewTaskActivity extends AppCompatActivity implements TaskInfoContract.View {
    private TaskInfoPresenter taskInfoPresenter;
    private EditText edtTitle, edtDescription, edtEndDate,edtCalendarEffort, edtCreatedDate;
    private Spinner spinStatus, spinEmployee;
    private TextView txtTaskID, txtProjectID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        init();

        txtTaskID= findViewById(R.id.txtTaskID);
        txtTaskID.setText(taskID+"");
        edtTitle = findViewById(R.id.edtTitle);
        edtDescription =findViewById(R.id.edtDesc);
        edtCalendarEffort = findViewById(R.id.edtCalendarEffort);
        edtCreatedDate = findViewById(R.id.edtCreatedDate);
        edtEndDate = findViewById(R.id.edtEndTaskTime);

        spinStatus = findViewById(R.id.spinStatus);
        spinEmployee = findViewById(R.id.spinEmployee);



        taskInfoPresenter.getTaskInfo(taskID,tokens);


    }

    private void init() {
        taskInfoPresenter = new TaskInfoPresenter();
        taskInfoPresenter.setmView(this);
    }

    @Override
    public void getTaskInfoSuccess(TaskInfoDTO dto) {
        System.out.println("alooooooooo"+dto);
        edtTitle.setText(dto.getTitle());
        edtDescription.setText(dto.getDescription());
        edtCalendarEffort.setText(dto.getCalendarEffort());
        edtCreatedDate.setText(dto.getCreatedDate());
        edtEndDate.setText(dto.getEndDate());
    }

    @Override
    public void getTaskInfoFailure(String message) {

    }
}
