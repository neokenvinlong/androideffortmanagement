package com.example.effortmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.model.dto.EmployeeTaskListItem;

import java.util.List;

public class EmployeeTaskListAdapter extends RecyclerView.Adapter<EmployeeTaskListAdapter.EmployeeTaskListViewHolder> {

    Context eContext;
    List<EmployeeTaskListItem> eData;

    public EmployeeTaskListAdapter(Context eContext, List<EmployeeTaskListItem> eData) {
        this.eContext = eContext;
        this.eData = eData;
    }

    @Override
    public EmployeeTaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(eContext).inflate(R.layout.item_employee_task, parent, false);
        return new EmployeeTaskListViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeTaskListViewHolder holder, int position) {
        holder.taskName.setText(eData.get(position).getTaskName());
        holder.status.setText(eData.get(position).getStatus());
        holder.effort.setText(eData.get(position).getEffot() + "");

    }

    @Override
    public int getItemCount() {
        return eData.size();
    }

    public class EmployeeTaskListViewHolder extends RecyclerView.ViewHolder {

        TextView taskName, status, effort;

        public EmployeeTaskListViewHolder(@NonNull View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.txtEmployeeTaskName);
            status = itemView.findViewById(R.id.txtEmployeeStatus);
            effort = itemView.findViewById(R.id.txtEmployeeEffort);
        }
    }

}
