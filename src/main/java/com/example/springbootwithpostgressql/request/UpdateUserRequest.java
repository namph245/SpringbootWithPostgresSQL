package com.example.springbootwithpostgressql.request;

import com.example.springbootwithpostgressql.response.BaseResponse;
import com.google.common.base.Strings;
import lombok.Data;

@Data
public class UpdateUserRequest extends BaseAuthRequest {

    private Integer userId;
    private String email;
    private String phoneNumber;
    private int role;
    private Long updateAt;
    private String updateBy;

    public BaseResponse validate() {

        BaseResponse response = new BaseResponse();

        if (userId == null) {
            response.setResult(-1, "Chưa truyền userId!");
            return response;
        }

        return null;
    }


}
