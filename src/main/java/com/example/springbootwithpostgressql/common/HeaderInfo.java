package com.example.springbootwithpostgressql.common;

import com.google.common.base.Strings;
import lombok.Data;

import java.util.List;

@Data
public class HeaderInfo {

    private String username;
    private Integer role;
    private String fullName;
    private List<String> permissions;


    private boolean validate() {
        return !Strings.isNullOrEmpty(username) && permissions != null;
    }
}
