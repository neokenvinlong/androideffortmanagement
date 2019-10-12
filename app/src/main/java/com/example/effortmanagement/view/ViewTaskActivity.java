package com.example.effortmanagement.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.effortmanagement.R;

import static com.example.effortmanagement.fragment.TaskListFragment.taskID;

public class ViewTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);

        TextView txtID = findViewById(R.id.txtTaskID);
        txtID.setText(taskID+"");


    }
}
