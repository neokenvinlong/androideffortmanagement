package com.example.effortmanagement.networking;

import com.example.effortmanagement.adapter.RetrofitAdapter;
import com.example.effortmanagement.networking.API.AccountService;

public class NetworkingUtils {
    private static AccountService accountService;

    public static AccountService getUserApiInstance() {
        if (accountService == null)
            accountService = RetrofitAdapter.getInstance().create(AccountService.class);

        return accountService;
    }
}
