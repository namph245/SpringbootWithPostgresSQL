package com.example.springbootwithpostgressql.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootwithpostgressql.request.LoginCommonRequest;
import com.example.springbootwithpostgressql.response.CommonDataResponse;
import com.example.springbootwithpostgressql.response.DataCheckUserCommonResponse;
import com.example.springbootwithpostgressql.common.JsonHelper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;


public class restTemplate {

    public static void main(String[] args) {

//        String accessToken = getAccessToken("testlgsp", "Lienthong#2o23@#@", "COMMON");
//        System.out.println("accessToken : " + accessToken);
//        isTokenExpired("asdjhfjdkgkjdlkasdmksad");
//        checkExistUsername("sjfjhjhasdhjgvsadasdsadhbasbfjkddklHDJIBF");
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJVc2VySWQiOiJkMTg1YjVmOC1iZmQ0LTQzNDAtOTBkZi1jODg0ZjY1ZTQyYTAiLCJuYW1laWQiOiJkMTg1YjVmOC1iZmQ0LTQzNDAtOTBkZi1jODg0ZjY1ZTQyYTAiLCJ1bmlxdWVfbmFtZSI6InRlc3RsZ3NwIiwiUGVybWlzc2lvbnMiOiJudWxsIiwiQ2FuQm9WaWV3TW9kZWwiOiJ7XCJJZFwiOlwiZWUyN2IzODktODIyMy00ZGE2LWI5NTUtMmVkMjVmNDQ0OTFiXCIsXCJDYW5Cb0RlcGFydG1lbnRJZFwiOlwiNTk2ZjhhZjUtZmRmNi00NmJlLWFmZDQtNmZiNjYxY2YxMjkzXCIsXCJIb1RlblwiOlwiTEdTUFwiLFwiQW5oRGFpRGllbl9GaWxlUGF0aFwiOlwiaHR0cHM6Ly9mdHBjb21tb24ubXBpLmdvdi52bi9cIixcIkNodWNWdVwiOlwiTMOhaSB4ZSAtUXXhuqNuIHRy4buLXCIsXCJEb25WaVwiOlwiUGjDsm5nIEPDtG5nIG5naOG7hyBwaOG6p24gbeG7gW1cIixcIkVtYWlsXCI6XCJ0ZXN0bGdzcEBtcGkuZ292LnZuXCIsXCJVc2VyTmFtZVwiOlwidGVzdGxnc3BcIixcIlVzZXJDYW5Cb0RlcGFydG1lbnRJZFwiOlwiNDBkMDQ5NjAtYWZhYi00M2Y0LTk2MTAtZjc0NWQ4OTU1YWRjXCIsXCJEb25WaUdvY1wiOntcIklkXCI6bnVsbCxcIlRlbkRvblZpXCI6bnVsbCxcIkNodWNWdUlkXCI6bnVsbCxcIkNodWNWdVwiOm51bGwsXCJNYUNodWNWdVwiOm51bGwsXCJMb2FpRG9uVmlYdUx5XCI6bnVsbCxcIkJpdF9Eb25WaUNvRGF1XCI6bnVsbH0sXCJEb25WaVRydWNUaHVvY1wiOntcIklkXCI6XCJjODNmMmQyNS1jY2M0LTQxMDUtOWY2ZC02ZWNmMTA3M2YyNWJcIixcIlRlbkRvblZpXCI6XCJQaMOybmcgQ8O0bmcgbmdo4buHIHBo4bqnbiBt4buBbVwiLFwiQ2h1Y1Z1SWRcIjpcIjZjYzQyZjNiLTg2NDAtNDY0OC05NDQwLWYwZjNiMWRlNmU3MFwiLFwiQ2h1Y1Z1XCI6XCJMw6FpIHhlIC1RdeG6o24gdHLhu4tcIixcIk1hQ2h1Y1Z1XCI6XCJMWFwiLFwiTG9haURvblZpWHVMeVwiOm51bGwsXCJCaXRfRG9uVmlDb0RhdVwiOm51bGx9LFwiR2lvaVRpbmhcIjpudWxsLFwiTmdheVNpbmhcIjpudWxsLFwiU29EaWVuVGhvYWlcIjpcIlwiLFwiUGhhbVZpSWRcIjpcImM4M2YyZDI1LWNjYzQtNDEwNS05ZjZkLTZlY2YxMDczZjI1YlwifSIsIkFwcENvZGUiOiJDT01NT04iLCJFbnZpcm9ubWVudCI6IldFQl9BUFAiLCJuYmYiOjE2ODE0MzkwMjUsImV4cCI6MTY4MTUyNjAyNSwiaWF0IjoxNjgxNDM5NjI1fQ.degpt8GYdTk0gOOIpNuQNKHFsYPZmBqm-Zd57hqWWAM";
        Boolean check = isTokenExpired(token);
        System.out.println("check = " + check);

    }

    public static String getAccessToken(String username, String password, String appCode) {
        RestTemplate restTemplate = new RestTemplate();
        String urlLogin = "https://apicommon.mpi.gov.vn/api/auth/login";


        LoginCommonRequest request = LoginCommonRequest.builder()
                .userName("testlgsp")
                .password("Lienthong#2o23@#@")
                .appCode("COMMON")
                .build();

        String body = JsonHelper.convertToJson(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        HttpEntity restRequestEntity = new HttpEntity(body, headers);
        ResponseEntity<Map> restResp = restTemplate.postForEntity(urlLogin, restRequestEntity, Map.class);
        Map<String, String> restRespBody = restResp.getBody();

        Gson gson = new Gson();
        CommonDataResponse dataResponse = gson.fromJson(new Gson().toJson(restRespBody.get("data"), new TypeToken<Object>() {
        }.getType()), CommonDataResponse.class);

        String accessToken = dataResponse.getAccessToken();
        return accessToken;
    }

    public static boolean checkExistUsername(String accessToken) {
        String url = "https://apicommon.mpi.gov.vn/api/users/is-username-existed";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

//        boolean checkIsTokenExpired = isTokenExpired(accessToken);

//        if (checkIsTokenExpired) {
//           accessToken =  getAccessToken("testlgsp", "Lienthong#2o23@#@", "COMMON");
//        }

        headers.add("Authorization", "Bearer " + accessToken);
        HttpEntity request = new HttpEntity(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        builder.queryParam("username", "testlgsp123");

        ResponseEntity<DataCheckUserCommonResponse> entity = restTemplate.exchange(
                builder.build().toUri(), HttpMethod.GET, request,
                DataCheckUserCommonResponse.class);

        System.out.println("response " + entity.getBody());
        System.out.println("success");

        return true;

    }

    public static boolean isTokenExpired(String token) {

            DecodedJWT decodedJWT = JWT.decode(token);
            Date expiresAt = decodedJWT.getExpiresAt();
            System.out.println("date : " + expiresAt.getTime());

            long timestamp = System.currentTimeMillis();
            System.out.println("time : " + timestamp);

            if (expiresAt.getTime() > timestamp) {
                return false;
            }
            return true;

    }
}
