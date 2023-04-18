package com.example.springbootwithpostgressql.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginCommonRequest {
    private String userName;
    private String password;
    private String appCode;

}
