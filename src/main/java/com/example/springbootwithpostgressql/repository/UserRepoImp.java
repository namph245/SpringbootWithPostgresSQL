package com.example.springbootwithpostgressql.repository;

import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImp implements UserRepo{

    @Override
    public GetArrayResponse<User> search(String username, String email, int page, int size) {

        GetArrayResponse<User> response = new GetArrayResponse<>();

//        String query = ""
        return null;
    }
}
