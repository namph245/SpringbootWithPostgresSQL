package com.example.springbootwithpostgressql.request;

import com.example.springbootwithpostgressql.response.BaseResponse;
import lombok.Data;

@Data
public class DeleteUserRequest extends BaseAuthRequest{

    private Integer userId;

    public BaseResponse validate() {
        BaseResponse response = new BaseResponse();

        if (userId == null) {
            response.setResult(-1, "Chưa truyền userId");
            return response;
        }

        return null;
    }
}
