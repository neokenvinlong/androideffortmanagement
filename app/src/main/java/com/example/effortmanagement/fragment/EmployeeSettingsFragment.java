package com.example.effortmanagement.fragment;

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
import com.example.effortmanagement.presenter.AccountInfoPresenter;

public class EmployeeSettingsFragment extends Fragment implements AccountInfoContract.View {

    private AccountInfoPresenter accountInfoPresenter;
    private TextView txtAccountName, txtFullname, txtEmail, txtPhone, txtSkill;
    private String account;
    private String token;
    private Button btnLogout;

    public EmployeeSettingsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_settings, container, false);

        init();

        token = this.getActivity().getIntent().getStringExtra("token");
        account = this.getActivity().getIntent().getStringExtra("account");

        txtAccountName = view.findViewById(R.id.txtAccountName);
        txtFullname = view.findViewById(R.id.txtFullName);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtSkill = view.findViewById(R.id.txtSkill);

        accountInfoPresenter.getAccountInfo(account,token);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Signed out successful", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });

        return view;
    }

    private void init() {
        accountInfoPresenter = new AccountInfoPresenter();
        accountInfoPresenter.setmView(this);
    }

    @Override
    public void getAccountInfoSuccess(AccountInfoDTO accountInfoDTO) {
        txtAccountName.setText(account);
        txtFullname.setText(accountInfoDTO.getName());
        txtEmail.setText(accountInfoDTO.getEmail());
        txtPhone.setText(accountInfoDTO.getPhone());
        txtSkill.setText(accountInfoDTO.getSkill());
    }

    @Override
    public void getAccountInfoFailure(String message) {
        System.out.println("Failllll");
    }


}
