package com.example.effortmanagement.model.dto;

import com.google.gson.annotations.SerializedName;

public class LoginAccountDTO {
    @SerializedName("username")
        private String username;
    @SerializedName("password")
        private String password;
        public LoginAccountDTO() {}

        public LoginAccountDTO(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

}
