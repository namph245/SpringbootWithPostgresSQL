package com.example.springbootwithpostgressql.request;

import com.example.springbootwithpostgressql.response.BaseResponse;
import lombok.Data;

@Data
public class UpdateUserTokenRequest {

    private Integer userId;
    private String token;

    public BaseResponse validate() {

        BaseResponse response = new BaseResponse();

        if (userId == null) {
            response.setResult(-1, "missing userId");
            return response;
        }

        return null;
    }
}
