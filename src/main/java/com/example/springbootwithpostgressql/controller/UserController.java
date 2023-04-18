package com.example.springbootwithpostgressql.controller;

import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.example.springbootwithpostgressql.common.ParseHeader;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.request.CreateUserRequest;
import com.example.springbootwithpostgressql.request.DeleteUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import com.example.springbootwithpostgressql.service.UserServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @ApiOperation("test")
    @GetMapping("/hello")
    public BaseResponse helloWord() {
        BaseResponse response = new BaseResponse();
        response.setMessage("say hello world");
        return response;
    }

    @ApiOperation("Get all + search + pagination")
    @GetMapping("/search")
    public GetArrayResponse<User> searchUser(
            @RequestHeader Map<String, String> headers,
            @RequestParam(value = "username", defaultValue ="", required = false) String username,
            @RequestParam(value = "email", defaultValue = "", required = false) String email,
            @RequestParam(value = "page", required = false) int page,
            @RequestParam(value = "size", required = false) int size
    ) {
        HeaderInfo headerInfo = ParseHeader.build(headers);
        GetArrayResponse<User> response = userServiceImp.search(headerInfo,username, email, page, size);
        return response;
    }

    @ApiOperation("Thêm mới một user")
    @PostMapping("/add")
    public BaseResponse createUser(
            @RequestHeader Map<String, String> headers,
            @RequestBody CreateUserRequest request)
    {
        BaseResponse response = new BaseResponse();

        if (request == null) {
            response.setResult(-1, "Vui lòng nhập đầy đủ thông tin của user");
            return response;
        }else{
            response = request.validate();
            if (response == null) {
                HeaderInfo headerInfo = ParseHeader.build(headers);
                request.setInfo(headerInfo);
                response = userServiceImp.add(request, headerInfo);
            }
        }
        return response;

    }

    @PostMapping("/edit")
    public BaseResponse updateAccount(
            @RequestHeader Map<String, String> headers,
            @RequestBody UpdateUserRequest request)
    {
        BaseResponse response = new BaseResponse();

        if (request == null) {
            response.setResult(-1, "Vui lòng nhập đầy đủ thông tin");
        }else{
            response = request.validate();

            if (response == null) {
                HeaderInfo headerInfo = ParseHeader.build(headers);
                request.setInfo(headerInfo);
                response = userServiceImp.update(request, headerInfo);
            }
        }

        return response;
    }

    @PostMapping("/delete")
    public BaseResponse delete(
            @RequestHeader Map<String, String> headers,
            @RequestBody DeleteUserRequest request) {

        BaseResponse response = new BaseResponse();

        if (request == null) {
            response.setResult(-1, "Vui lòng nhập đầy đủ thông tin");

        }else{
            response = request.validate();
            if (response == null) {
                HeaderInfo headerInfo = ParseHeader.build(headers);
                request.setInfo(headerInfo);
                response = userServiceImp.delete(request);
            }
        }

        return response;
    }

}
