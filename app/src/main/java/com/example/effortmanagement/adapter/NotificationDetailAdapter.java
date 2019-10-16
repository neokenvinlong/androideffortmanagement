package com.example.effortmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.model.dto.NotificationDetailDTO;

import java.util.List;

public class NotificationDetailAdapter extends RecyclerView.Adapter<NotificationDetailAdapter.NotificationDetailViewHolder> {

    Context eContext;
    List<NotificationDetailDTO> eData;
    private NotificationDetailAdapter.OnTaskListener mOnTaskListener;


    public NotificationDetailAdapter(Context eContext, List<NotificationDetailDTO> eData, OnTaskListener mOnTaskListener) {
        this.eContext = eContext;
        this.eData = eData;
        this.mOnTaskListener = mOnTaskListener;
    }

    @NonNull
    @Override
    public NotificationDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(eContext).inflate(R.layout.item_notification_list,parent,false);
        return new NotificationDetailViewHolder(layout, mOnTaskListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationDetailViewHolder holder, int position) {
        holder.taskName.setText(eData.get(position).getTitle());
        holder.actual_effort.setText(eData.get(position).getActualEffort()+"");
        holder.calendar_effort.setText(eData.get(position).getCalendarEffort() + "");
        holder.effortID.setText(eData.get(position).getEffortID()+"");
        holder.accountName.setText(eData.get(position).getAccountName());
    }

    @Override
    public int getItemCount() {
        return eData.size();
    }

    public class NotificationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView taskName, actual_effort, calendar_effort,effortID, accountName;// task_id;
        Button btnApprove, btnReject;
        OnTaskListener onTaskListener;

        public NotificationDetailViewHolder(@NonNull View itemView, final OnTaskListener onTaskListener) {
            super(itemView);

            taskName = itemView.findViewById(R.id.txtEmployeeTaskName);
            actual_effort = itemView.findViewById(R.id.txtActualEffort);
            calendar_effort = itemView.findViewById(R.id.txtCalendarEffort);
            effortID = itemView.findViewById(R.id.txtEffortID);
            accountName = itemView.findViewById(R.id.txtAccountName);

            btnApprove = itemView.findViewById(R.id.btnApprove);
            btnReject = itemView.findViewById(R.id.btnReject);
            this.onTaskListener = onTaskListener;

            btnApprove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnTaskListener.onTaskClick(getPosition());
                }
            });

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
