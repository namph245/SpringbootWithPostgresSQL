package com.example.springbootwithpostgressql.response;

import lombok.Data;

@Data
public class LoginResponse extends BaseResponse{
    private String token;
    private String username;
    private Integer role;
    private boolean isAdmin;
}
