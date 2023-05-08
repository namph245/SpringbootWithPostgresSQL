package com.example.springbootwithpostgressql.repository;

import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.request.CreateUserRequest;
import com.example.springbootwithpostgressql.request.DeleteUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserTokenRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo {

    GetArrayResponse<User> search(String username, String email, int page, int size);

    User findUserByUsername(String username);

    BaseResponse save(CreateUserRequest user, String username);

    BaseResponse update(UpdateUserRequest user, String username);

    BaseResponse updateUserToken(UpdateUserTokenRequest user);

    BaseResponse delete(DeleteUserRequest request);


}
