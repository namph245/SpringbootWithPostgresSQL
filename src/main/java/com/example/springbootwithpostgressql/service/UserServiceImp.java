package com.example.springbootwithpostgressql.service;

import com.example.springbootwithpostgressql.common.Constant;
import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.repository.UserRepo;
import com.example.springbootwithpostgressql.request.CreateUserRequest;
import com.example.springbootwithpostgressql.request.DeleteUserRequest;
import com.example.springbootwithpostgressql.request.UpdateUserRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public GetArrayResponse<User> search(HeaderInfo headerInfo, String username, String email, int page, int size) {

        GetArrayResponse<User> response = new GetArrayResponse<>();

        User user = userRepo.findUserByUsername(headerInfo.getUsername());

        if (user == null) {
            response.setCode(-1);
            response.setMessage("Người dùng không tồn tại");
            return response;
        }

        if (user.getRole() != Constant.UserRole.ADMIN_VALUE) {
            response.setCode(-1);
            response.setMessage("Người dùng không có quyền truy cập");
            return response;
        }

        try {

            response = userRepo.search(username, email, page, size);

        }catch (Exception ex) {
            response.setMessage("xảy ra lỗi hệ thống : " + ex);
            System.out.println("Lỗi search user : " + ex);
        }

        return response;

    }

    @Override
    public BaseResponse add(CreateUserRequest createUserRequest, HeaderInfo headerInfo) {

        BaseResponse response;
        response = userRepo.save(createUserRequest, headerInfo.getUsername());

        if (response.getCode() == 1) {
            response.setResult(200, "ok");
            return response;
        }else {
            response.setResult(-1, response.getMessage());
        }

        return response;
    }

    @Override
    public BaseResponse update(UpdateUserRequest updateUserRequest, HeaderInfo headerInfo) {

        BaseResponse response;
        response = userRepo.update(updateUserRequest, headerInfo.getUsername());

        if (response.getCode() == 1) {
            response.setResult(200, "update ok");
        }else{
            response.setResult(-1, response.getMessage());
        }

        return response;
    }

    @Override
    public BaseResponse delete(DeleteUserRequest request) {

        BaseResponse response;
        response = userRepo.delete(request);

        if (response.getCode() == 1) {
            response.setResult(200, "delete ok");
        }else{
            response.setResult(-1, response.getMessage());
        }

        return response;
    }

}
