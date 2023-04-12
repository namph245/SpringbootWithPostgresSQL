package com.example.springbootwithpostgressql.controller;

import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.example.springbootwithpostgressql.common.ParseHeader;
import com.example.springbootwithpostgressql.entity.User;
import com.example.springbootwithpostgressql.response.BaseResponse;
import com.example.springbootwithpostgressql.response.GetArrayResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("test")
    @GetMapping("/hello")
    public BaseResponse helloWord() {
        BaseResponse response = new BaseResponse();
        response.setMessage("say hello word");
        return response;
    }

    @GetMapping("/search")
    public GetArrayResponse<User> searchUser(
            @RequestHeader Map<String, String> headers,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "size", required = false) String size
    ) {
        HeaderInfo headerInfo = ParseHeader.build(headers);
        GetArrayResponse<User> response =




    }

}
