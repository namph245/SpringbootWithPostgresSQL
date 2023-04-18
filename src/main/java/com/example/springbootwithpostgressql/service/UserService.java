package com.example.springbootwithpostgressql.service;

import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.example.springbootwithpostgressql.entity.Avatar;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.request.CreateUserRequest;
import com.example.springbootwithpostgressql.request.DeleteUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;

import java.util.List;

public interface UserService {

    GetArrayResponse<User> search(HeaderInfo headerInfo, String username, String email, int page, int size);

    BaseResponse add(CreateUserRequest createUserRequest, HeaderInfo headerInfo);

    BaseResponse update(UpdateUserRequest updateUserRequest, HeaderInfo headerInfo);

    BaseResponse delete(DeleteUserRequest request);
}
