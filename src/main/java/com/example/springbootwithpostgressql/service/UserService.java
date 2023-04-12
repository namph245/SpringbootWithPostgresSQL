package com.example.springbootwithpostgressql.service;

import com.example.springbootwithpostgressql.entity.Avatar;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.response.GetArrayResponse;

import java.util.List;

public interface UserService {

    GetArrayResponse<User> search(String key, int page, int size);

    void saveAvatar(List<Avatar> listAvatar);


}
