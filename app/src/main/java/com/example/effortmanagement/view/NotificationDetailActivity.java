package com.example.effortmanagement.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.effortmanagement.R;
import com.example.effortmanagement.adapter.NotificationDetailAdapter;
import com.example.effortmanagement.contract.ApproveEffortContract;
import com.example.effortmanagement.contract.NotificationDetailContract;
import com.example.effortmanagement.model.dto.NotificationDetailDTO;
import com.example.effortmanagement.presenter.ApproveEffortPresenter;
import com.example.effortmanagement.presenter.NotificationDetailPresenter;

import java.util.List;
import static com.example.effortmanagement.view.LoginActivity.tokens;

public class NotificationDetailActivity extends AppCompatActivity implements NotificationDetailContract.View
        , NotificationDetailAdapter.OnTaskListener, ApproveEffortContract.View {

    RecyclerView notificationDetailRecyclerView;
    LinearLayout notificationDetailRecyclerViewLayout;
    private NotificationDetailAdapter notificationDetailAdapter;
    private NotificationDetailPresenter notificationDetailPresenter;
    private ApproveEffortPresenter approveEffortPresenter;
    private List<NotificationDetailDTO> notificationList;
    private Button btnApprove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);
        init();


        notificationDetailRecyclerView = findViewById(R.id.listNotification);
        notificationDetailRecyclerViewLayout = findViewById(R.id.listNotificationLayout);
        //btnApprove = findViewById(R.id.btnApprove);

        //System.out.println("Token la "+tokens);
        notificationDetailPresenter.getNotificationInfo(tokens);
    }
    private void init(){
        notificationDetailPresenter = new NotificationDetailPresenter();
        notificationDetailPresenter.setmView(this);

        approveEffortPresenter = new ApproveEffortPresenter();
        approveEffortPresenter.setmView(this);
    }
    private void getNotificationList(List<NotificationDetailDTO> listDTO){
        this.notificationList = listDTO;
    }

    @Override
    public void getNotificationInfoSuccess(List<NotificationDetailDTO> listDTO) {

        notificationDetailAdapter = new NotificationDetailAdapter(this, listDTO, this);

        notificationDetailRecyclerView.setAdapter(notificationDetailAdapter);
        notificationDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getNotificationList(listDTO);
    }

    @Override
    public void getNotificationInfoFailure(String message) {

    }

    @Override
    public void onTaskClick(final int position) {
        //System.out.println(notificationList.get(position).getEffortID()+"aaaaaaaa");
        approveEffortPresenter.updateApproveEffort(notificationList.get(position).getEffortID(),tokens);
        Toast.makeText(this, "Approved !!!", Toast.LENGTH_SHORT).show();
        notificationDetailPresenter.getNotificationInfo(tokens);
    }

    @Override
    public void updateApproveEffortSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateApproveEffortFailure(String message) {

    }
}
