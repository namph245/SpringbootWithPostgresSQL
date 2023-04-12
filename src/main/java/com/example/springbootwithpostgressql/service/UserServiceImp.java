package com.example.springbootwithpostgressql.service;

import com.example.springbootwithpostgressql.entity.Avatar;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Override
    public GetArrayResponse<User> search(String key, int page, int size) {
        return null;
    }

    @Override
    public void saveAvatar(List<Avatar> listAvatar) {

    }

    private final
}
