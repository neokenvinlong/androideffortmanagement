package com.example.effortmanagement.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.EmployeeProContract;
import com.example.effortmanagement.contract.TaskInfoContract;
import com.example.effortmanagement.contract.TaskUpdateContract;
import com.example.effortmanagement.model.dto.EmployeeProDTO;
import com.example.effortmanagement.model.dto.TaskCreDTO;
import com.example.effortmanagement.model.dto.TaskInfoDTO;
import com.example.effortmanagement.presenter.EmployeeProPresenter;
import com.example.effortmanagement.presenter.TaskInfoPresenter;
import com.example.effortmanagement.presenter.TaskUpdatePresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.effortmanagement.fragment.TaskListFragment.taskID;
import static com.example.effortmanagement.view.LoginActivity.tokens;

public class ViewTaskActivity extends AppCompatActivity implements TaskInfoContract.View, EmployeeProContract.View
, TaskUpdateContract.View {
    private TaskInfoPresenter taskInfoPresenter;
    private EmployeeProPresenter employeeProPresenter;
    private TaskUpdatePresenter taskUpdatePresenter;
    EditText edtTitle, edtDescription, edtEndDate, edtCalendarEffort, edtCreatedDate;
    private Spinner spinStatus, spinEmployee;
    private TextView txtTaskID, txtProjectID,txtEmployeeID;
    private Button btnSave;
    private String date;
    private String statusResult;
    private TaskCreDTO taskCreate;
    private int employeeID;
    private int projectID;
    private int empID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        init();

        txtTaskID = findViewById(R.id.txtTaskID);
        txtProjectID = findViewById(R.id.txtProjectID);
        txtEmployeeID = findViewById(R.id.txtEmployeeID);
        //txtTaskID.setText(taskID+"");
        edtTitle = findViewById(R.id.edtTitle);
        edtDescription = findViewById(R.id.edtDesc);
        edtCalendarEffort = findViewById(R.id.edtCalendarEffort);
        edtCreatedDate = findViewById(R.id.edtCreatedDate);
        edtEndDate = findViewById(R.id.edtEndTaskTime);

        spinStatus = findViewById(R.id.spinStatus);
        spinEmployee = findViewById(R.id.spinEmployee);


        taskInfoPresenter.getTaskInfo(taskID, tokens);


    }

    private void init() {
        taskInfoPresenter = new TaskInfoPresenter();
        taskInfoPresenter.setmView(this);

        employeeProPresenter = new EmployeeProPresenter();
        employeeProPresenter.setmView(this);

        taskUpdatePresenter = new TaskUpdatePresenter();
        taskUpdatePresenter.setmView(this);
    }

    @Override
    public void getTaskInfoSuccess(final TaskInfoDTO dto) {
        edtTitle.setText(dto.getTitle());
        edtDescription.setText(dto.getDescription());
        edtCalendarEffort.setText(dto.getCalendarEffort() + "");
        edtCreatedDate.setText(dto.getCreatedDate());
        edtEndDate.setText(dto.getEndDate());
        edtEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtEndDate.setText("");
                getDate();
            }
        });
        txtProjectID.setText(dto.getProjectID() + "");
        txtTaskID.setText(dto.getTaskID() + "");
        txtEmployeeID.setText(dto.getEmployeeID()+"");

        empID = dto.getEmployeeID();
        projectID = dto.getProjectID();

        String status = dto.getStatus();
        spinStatus.setSelection(getIndex(spinStatus, status));
//        statusResult = spinStatus.getSelectedItem().toString();
//        System.out.println("status result la "+statusResult);

        btnSave = findViewById(R.id.btnUpdate);


        doSomething(dto.getEmployeeID());

        employeeProPresenter.getEmployeeProInfo(dto.getProjectID(),tokens);

    }

    @Override
    public void getTaskInfoFailure(String message) {

    }

    private void getDate() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                edtEndDate.setText(simpleDateFormat.format(calendar.getTime()));
                date = edtEndDate.getText().toString();
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private int getIndex(Spinner spinner, String myString){
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
            }
        }
        return index;
    }

    private void doSomething(int employeeID1){
        employeeID = employeeID1;
        Toast.makeText(this, employeeID+ " success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getEmployeeProInfoSuccess(final List<EmployeeProDTO> listDTO) {
        List<String> employeeName = new ArrayList<>();
        for (EmployeeProDTO dto: listDTO){
            employeeName.add(dto.getEmployeeName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, employeeName);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinEmployee.setAdapter(dataAdapter);

        String empName;
        for(int i = 0; i < listDTO.size(); i++){
            if(empID == listDTO.get(i).getEmployeeID()){
                empName = listDTO.get(i).getEmployeeName();
                System.out.println("aaa"+empName);
                spinEmployee.setSelection(getIndex(spinEmployee,empName));
                break;
            }
        }

        spinEmployee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String empName = parent.getItemAtPosition(position).toString();
                System.out.println(empName);
                for(EmployeeProDTO dto: listDTO){
                    if(empName.equals(dto.getEmployeeName())){
                        employeeID = dto.getEmployeeID();
                        doSomething(dto.getEmployeeID());
                        break;
                    }
                }
                //spinner.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //click button

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String desc = edtDescription.getText().toString();
                statusResult = spinStatus.getSelectedItem().toString();
                date = edtEndDate.getText().toString();
//                System.out.println("status result la "+statusResult);
                int calendarEffort = Integer.valueOf(edtCalendarEffort.getText().toString());
                taskCreate = new TaskCreDTO(taskID,title,desc,statusResult,date,calendarEffort,projectID,employeeID);

                System.out.println("update tra ve la"+taskCreate.getTaskId());
                System.out.println("update tra ve la"+taskCreate.getTitle());
                System.out.println("update tra ve la"+taskCreate.getDescription());
                System.out.println("update tra ve la"+taskCreate.getStatus());
                System.out.println("update tra ve la"+taskCreate.getEndDate());
                System.out.println("update tra ve la"+taskCreate.getCalendarEffort());
                System.out.println("update tra ve la"+taskCreate.getProjectId());
                System.out.println("update tra ve la"+taskCreate.getEmployeeId());

                if(checkUpdate(title,calendarEffort)){
                    taskUpdatePresenter.getTaskUpdate(taskCreate, tokens);
                    Toast.makeText(ViewTaskActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(NewActivity.this, MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
                    finish();
                }
            }
        });

    }

    @Override
    public void getEmployeeProInfoFailure(String message) {

    }

    @Override
    public void getTaskUpdateSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getTaskUpdateFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean checkUpdate(String title, int calendarEffort) {
        boolean isValid = true;
        if (title.equals("")) {
            edtTitle.setError("Title Task is required !");
            isValid = false;
        }
        if (calendarEffort == 0) {
            edtCalendarEffort.setError("Calendar Effort is required !");
            isValid = false;
        }
//        if(!endDate.matches("(([0-9]{4})-([0-9]{2})-([0-9]{2}))"))
//        if(endDate == null){
//            edtEndDate.setError("End task time is required!");
//            isValid = false;
//        }
        return isValid;
    }
}
