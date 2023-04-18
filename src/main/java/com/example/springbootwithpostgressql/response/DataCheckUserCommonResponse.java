package com.example.springbootwithpostgressql.response;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataCheckUserCommonResponse {
    private Boolean data;
    private int statusCode;
    private Boolean succeeded;
    private int code;
    private String message;
}
