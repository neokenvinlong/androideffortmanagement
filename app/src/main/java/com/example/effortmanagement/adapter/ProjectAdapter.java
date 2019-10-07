package com.example.effortmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.fragment.ProjectItem;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    Context mContext;
    List<ProjectItem> mData;

    public ProjectAdapter(Context mContext, List<ProjectItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_projects,viewGroup,false);
        return new ProjectViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder projectViewHolder, int position) {
        projectViewHolder.projectName.setText(mData.get(position).getProjectName());
        projectViewHolder.projectStatus.setText(mData.get(position).getProjectStatus());
        projectViewHolder.totalTask.setText(mData.get(position).getTotalTask()+"");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder{

        TextView projectName, projectStatus, totalTask;

        public ProjectViewHolder(@NonNull View itemView){
            super(itemView);
            projectName = itemView.findViewById(R.id.project_name);
            projectStatus = itemView.findViewById(R.id.project_status);
            totalTask = itemView.findViewById(R.id.task_total);
        }
    }

    public void updateList(List<ProjectItem> projectList){
        mData = new ArrayList<>();
        mData.addAll(projectList);
        notifyDataSetChanged();
    }
}
