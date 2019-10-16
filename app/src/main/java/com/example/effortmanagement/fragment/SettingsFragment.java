package com.example.effortmanagement.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.effortmanagement.R;
import com.example.effortmanagement.contract.AccountInfoContract;
import com.example.effortmanagement.model.dto.AccountInfoDTO;
import com.example.effortmanagement.model.dto.LoginRoleAccountDTO;
import com.example.effortmanagement.presenter.AccountInfoPresenter;
import com.example.effortmanagement.presenter.AccountPresenter;
import com.example.effortmanagement.presenter.RolePresenter;
import com.example.effortmanagement.view.LoginActivity;
import com.example.effortmanagement.view.NotificationDetailActivity;

import org.w3c.dom.Text;

public class SettingsFragment extends Fragment implements AccountInfoContract.View {

    private AccountInfoPresenter accountInfoPresenter;
    private TextView accountName;
    private TextView fullName;
    private TextView email;
    private TextView phone;
    private TextView skill;
    private String account;
    private String token;
    public SettingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_settings, container, false);

        init();

        account = getActivity().getIntent().getStringExtra("account");
        token = getActivity().getIntent().getStringExtra("token");

        accountName = view.findViewById(R.id.txtAccountName);
        fullName = view.findViewById(R.id.txtFullName);
        email = view.findViewById(R.id.txtEmail);
        phone = view.findViewById(R.id.txtPhone);
        skill = view.findViewById(R.id.txtSkill);


        accountInfoPresenter.getAccountInfo(account,token);
        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Signed out successful", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
        Button btnNotification = view.findViewById(R.id.btnNotification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(container.getContext(), NotificationDetailActivity.class);
                startActivity(intent);
            }
        });

//        accounts.setText(account);


        return view;
    }

    private void init() {
        accountInfoPresenter = new AccountInfoPresenter();
        accountInfoPresenter.setmView(this);
    }

    @Override
    public void getAccountInfoSuccess(AccountInfoDTO accountInfoDTO) {
        accountName.setText(account);
        fullName.setText(accountInfoDTO.getName());
        email.setText(accountInfoDTO.getEmail());
        phone.setText(accountInfoDTO.getPhone());
        skill.setText(accountInfoDTO.getSkill());
    }

    @Override
    public void getAccountInfoFailure(String message) {
        System.out.println("Failllll");
    }


}
