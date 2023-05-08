package com.example.springbootwithpostgressql.service;

import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.example.springbootwithpostgressql.request.LoginRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.LoginResponse;


public interface AuthenticationService {

    LoginResponse login(LoginRequest request);

    BaseResponse logout(HeaderInfo headerInfo);
}
