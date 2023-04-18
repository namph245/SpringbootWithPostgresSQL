package com.example.springbootwithpostgressql.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonDataResponse {
    private CommonUserInfoResponse userInformation;
    private String accessToken;
}
