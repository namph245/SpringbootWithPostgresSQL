package com.example.springbootwithpostgressql.test;

import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "https://vnexpress.net/the-gioi";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept", "text/html");
////        headers.add("Authorization", "Bearer "+ bearer);
//
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        restTemplate.getMessageConverters().add(converter);
//
//        HttpEntity request = new HttpEntity(headers);
//        HttpEntity <String> entity = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
//
//        System.out.println("data lay ra : " + entity.getBody());

        // get time stamp
        long unixTime = System.currentTimeMillis() / 1000L;
        System.out.println("unix time = " + unixTime);




    }
}
