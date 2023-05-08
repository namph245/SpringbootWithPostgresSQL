package com.example.springbootwithpostgressql.controller;

import com.example.springbootwithpostgressql.request.LoginRequest;
import com.example.springbootwithpostgressql.response.LoginResponse;
import com.example.springbootwithpostgressql.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
public class AuthenticationController{

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @ApiOperation("Đăng nhập vào hệ thống")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response =  request.validate();
        if (response == null) {
            response = authenticationService.login(request);
        }

        return ResponseEntity.ok(response);
    }
}
