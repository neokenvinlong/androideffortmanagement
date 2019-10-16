package com.example.effortmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.model.dto.EmployeeTaskListDTO;

import java.util.List;

public class EmployeeTaskListAdapter extends RecyclerView.Adapter<EmployeeTaskListAdapter.EmployeeTaskListViewHolder> {

    Context eContext;
    List<EmployeeTaskListDTO> eData;
    private OnTaskListener mOnTaskListener;
   // public static int task_id;

    public EmployeeTaskListAdapter(Context eContext, List<EmployeeTaskListDTO> eData, OnTaskListener onTaskListener) {
        this.eContext = eContext;
        this.eData = eData;
        this.mOnTaskListener = onTaskListener;
    }

    @Override
    public EmployeeTaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(eContext).inflate(R.layout.item_employee_task, parent, false);
        return new EmployeeTaskListViewHolder(layout, mOnTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeTaskListViewHolder holder, int position) {
        holder.taskName.setText(eData.get(position).getTitle());
        holder.status.setText(eData.get(position).getStatus());
        holder.calendar_effort.setText(eData.get(position).getCalendar_effort() + "");

//        task_id = eData.get(position).getTask_id();
//        holder.task_id.setText(task_id + "");
    }

    @Override
    public int getItemCount() {
        return eData.size();
    }


    public class EmployeeTaskListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView taskName, status, calendar_effort;// task_id;
        OnTaskListener onTaskListener;

        public EmployeeTaskListViewHolder(@NonNull View itemView, OnTaskListener onTaskListener) {
            super(itemView);

            taskName = itemView.findViewById(R.id.txtEmployeeTaskName);
            status = itemView.findViewById(R.id.txtEmployeeStatus);
            calendar_effort = itemView.findViewById(R.id.txtEmployeeEffort);
            //  task_id = itemView.findViewById(R.id.txtTaskID1);
            this.onTaskListener = onTaskListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTaskListener.onTaskClick(getAdapterPosition());
        }
    }

    public interface OnTaskListener{
        void onTaskClick(int position);
    }

}
