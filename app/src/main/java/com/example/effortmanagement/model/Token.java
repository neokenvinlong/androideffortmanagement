package com.example.effortmanagement.model;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("token")
    private String tokens;

    public Token() {
    }

    public Token(String tokens) {
        this.tokens = tokens;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }
}
