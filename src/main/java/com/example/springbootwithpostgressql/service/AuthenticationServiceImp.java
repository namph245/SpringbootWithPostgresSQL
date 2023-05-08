package com.example.springbootwithpostgressql.service;

import com.example.springbootwithpostgressql.common.AppUtils;
import com.example.springbootwithpostgressql.common.Common;
import com.example.springbootwithpostgressql.common.Constant;
import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.repository.UserRepo;
import com.example.springbootwithpostgressql.request.LoginRequest;
import com.example.springbootwithpostgressql.request.UpdateUserTokenRequest;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.LoginResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class AuthenticationServiceImp implements AuthenticationService{

    private final UserRepo userRepo;

    public AuthenticationServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        LoginResponse response = new LoginResponse();

        String username = request.getUsername().trim();
        User user = userRepo.findUserByUsername(username);
        if (user == null) {
            response.setResult(-1, "Thất bại, Người dùng không tồn tại");
            return response;
        }

        if (!user.getPassword().equals(request.getPassword())) { // String thì dùng equal
            response.setResult(-1, "Thất bại, Mật khẩu không đúng");
            return response;
        }

        // lấy token
        String token = generateToken(username);

        UpdateUserTokenRequest update = new UpdateUserTokenRequest();
        update.setUserId(AppUtils.parseInt(user.getId()));
        update.setToken(token);

        // lưu token vào db
        BaseResponse baseResponse = userRepo.updateUserToken(update);
        if (baseResponse.getCode() != 0) {
            response.setToken(token);
            response.setRole(user.getRole());
            response.setUsername(username);

            if (user.getRole() == Constant.UserRole.ADMIN_VALUE) {
                response.setAdmin(true);
            }

            response.setAdmin(false);
            response.setCode(200);
        }
        return response;
    }

    @Override
    public BaseResponse logout(HeaderInfo headerInfo) {
        return null;
    }

    private String generateToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, Common.SECRET.getBytes(StandardCharsets.UTF_8))
                .setIssuedAt(date)
                .compact();
    }
}
