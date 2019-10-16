package com.example.effortmanagement.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.EmployeeTaskDetailContract;
import com.example.effortmanagement.contract.EmployeeUpdateEffortContract;
import com.example.effortmanagement.model.dto.EmployeeTaskDetailDTO;
import com.example.effortmanagement.model.dto.EmployeeUpdateEffortDTO;
import com.example.effortmanagement.presenter.EmployeeTaskDetailPresenter;
import com.example.effortmanagement.presenter.EmployeeUpdateEffortPresenter;

import static com.example.effortmanagement.view.LoginActivity.tokens;

public class EmployeeTaskDetailActivity extends AppCompatActivity implements EmployeeTaskDetailContract.View, EmployeeUpdateEffortContract.View {

    private TextView txtTitle, txtDescription, txtStatus, txtCreatedDate, txtEndDate, txtCalendarEffort, txtActualEffort, txtTaskId;
    private int task_id;
    private EmployeeTaskDetailPresenter employeeTaskDetailPresenter;
    private EmployeeUpdateEffortPresenter employeeUpdateEffortPresenter;
    private Button btnEmployeeUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_task_detail);

        init();

        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.txtDescription);
        txtStatus = findViewById(R.id.txtStatus);
        txtCreatedDate = findViewById(R.id.txtCreatedDate);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtCalendarEffort = findViewById(R.id.txtCalendarEffort);
        txtActualEffort = findViewById(R.id.txtActualEffort);
        txtTaskId = findViewById(R.id.txtTaskID);
        btnEmployeeUpdate = findViewById(R.id.btnEmployeeUpdate);

        task_id = Integer.parseInt(this.getIntent().getStringExtra("TASK_ID"));
        System.out.println("TASK_ID la: "+task_id);
        employeeTaskDetailPresenter.getInfoOfTaskByTaskId(task_id, tokens);

    }

    private void init(){
        employeeTaskDetailPresenter = new EmployeeTaskDetailPresenter();
        employeeTaskDetailPresenter.setView(this);

        employeeUpdateEffortPresenter = new EmployeeUpdateEffortPresenter();
        employeeUpdateEffortPresenter.setView(this);
    }

    @Override
    public void getInfoOfTaskByTaskIdSuccess(EmployeeTaskDetailDTO employeeTaskDetailDTO) {
        txtTitle.setText(employeeTaskDetailDTO.getTitle());
        txtDescription.setText(employeeTaskDetailDTO.getDescription());
        txtStatus.setText(employeeTaskDetailDTO.getStatus());
        txtCalendarEffort.setText(employeeTaskDetailDTO.getCalendar_effort()+"");
        txtCreatedDate.setText(employeeTaskDetailDTO.getCreated_date()+"");
        txtEndDate.setText(employeeTaskDetailDTO.getEnd_date()+"");
        txtActualEffort.setText(employeeTaskDetailDTO.getEffort()+"");
        txtTaskId.setText(employeeTaskDetailDTO.getTask_id()+"");

        btnEmployeeUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int task_id = Integer.parseInt(txtTaskId.getText().toString());
                    System.out.println("TASK_ID 2 la: "+task_id);
                    double effort = Double.parseDouble(txtActualEffort.getText().toString());
                    EmployeeUpdateEffortDTO employeeUpdateEffortDTO = new EmployeeUpdateEffortDTO(effort, task_id);
                    employeeUpdateEffortPresenter.updateEffort(employeeUpdateEffortDTO, tokens);
                    finish();
                }catch (Exception ex){
                    Toast.makeText(EmployeeTaskDetailActivity.this, "Effort invalid", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void getInfoOfTaskByTaskIdFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

//    public void clickToUpdate(View view) {
//        int task_id = Integer.parseInt(txtTaskId.getText().toString());
//        double effort = Double.parseDouble(txtActualEffort.getText().toString());
//        EmployeeUpdateEffortDTO employeeUpdateEffortDTO = new EmployeeUpdateEffortDTO(effort, task_id);
//        employeeUpdateEffortPresenter.updateEffort(employeeUpdateEffortDTO, tokens);
//    }

    public void clickToCancel(View view) {
        onBackPressed();
    }

    @Override
    public void updateEffortSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateEffortFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
