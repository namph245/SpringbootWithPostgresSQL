package com.example.springbootwithpostgressql.request;

import com.example.springbootwithpostgressql.response.LoginResponse;
import com.google.common.base.Strings;
import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

    public LoginResponse validate() {

        LoginResponse response = new LoginResponse();

        if (Strings.isNullOrEmpty(username)) {
            response.setResult(-1, "Đây là trường bắt buộc nhập");
        }

        if (Strings.isNullOrEmpty(password)) {
            response.setResult(-1, "Đây là trường bắt buộc nhập");
        }

        return null;
    }
}
