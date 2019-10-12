package com.example.effortmanagement.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.effortmanagement.R;
import com.example.effortmanagement.model.Task;
import com.example.effortmanagement.model.dto.ProjectByPMDTO;
import com.example.effortmanagement.view.MainActivity;
import com.example.effortmanagement.view.NewActivity;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<ProjectByPMDTO> listDataHeader; // header titles
    // child data in format of header title, child title
    private List<List<Task>> _listDataChild;
    private List<TextView> txtId;
    public ExpandableListAdapter(Context context, List<ProjectByPMDTO> listDataHeader, List<List<Task>> _listDataChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this._listDataChild = _listDataChild;
        txtId = new ArrayList<>();
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(groupPosition);
//                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_view_items, null);
        }


        TextView listViewItem = convertView.findViewById(R.id.lvItem);
        ArrayList<Task> item = (ArrayList) getChild(groupPosition,childPosition);
        listViewItem.setText(item.get(childPosition).getTitle());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded,
                             View convertView, final ViewGroup parent) {
//        ProjectByPMDTO headerTitle = (ProjectByPMDTO) getGroup(groupPosition);
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this.context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.list_group, null);
//        }
//
//        TextView lblListHeader = (TextView) convertView
//                .findViewById(R.id.lblListHeader);
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle.getProjectName());
//
//        return convertView;
        ProjectByPMDTO headerTitle = (ProjectByPMDTO) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
            txtId.add((TextView) convertView.findViewById(R.id.lblId));

            final View finalConvertView = convertView;
            convertView.findViewById(R.id.btnAddTask).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(finalConvertView.getContext(), NewActivity.class);
                    String projectID = txtId.get(groupPosition).getText().toString();
                    intent.putExtra("projectid",projectID);
                    finalConvertView.getContext().startActivity(intent);
                    System.out.println(projectID);
                }
            });

        }

        TextView lblListHeader = convertView
                .findViewById(R.id.lblListHeader);
        TextView lblListId = convertView
                .findViewById(R.id.lblId);

        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle.getProjectName());
        lblListId.setText(headerTitle.getProjectId() + "");

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
