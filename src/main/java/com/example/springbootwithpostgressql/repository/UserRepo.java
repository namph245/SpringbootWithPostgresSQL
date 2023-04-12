package com.example.springbootwithpostgressql.repository;

import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import com.example.springbootwithpostgressql.response.GetSingleItemResponse;

public interface UserRepo {

    GetArrayResponse<User> search(String username, String email, int page, int size);

//    BaseResponse createUser()




}
