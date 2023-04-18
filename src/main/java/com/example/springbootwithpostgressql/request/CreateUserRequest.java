package com.example.springbootwithpostgressql.request;

import com.example.springbootwithpostgressql.common.AppUtils;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.google.common.base.Strings;
import lombok.Data;

@Data
public class CreateUserRequest extends BaseAuthRequest{
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private int role;
    private Long createAt;
    private Long updateAt;
    private Boolean active;
    private String createBy;
    private String updateBy;


    public BaseResponse validate() {

        BaseResponse response = new BaseResponse();

        if (Strings.isNullOrEmpty(username)) {
            response.setResult(-1, "Vui lòng nhập username");
            return response;
        }

        if (!AppUtils.validateUsername(username)) {
            response.setResult(-1, "Username không đúng");
            return response;
        }

        return null;
    }
}
