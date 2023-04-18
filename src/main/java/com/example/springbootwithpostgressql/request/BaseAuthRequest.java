package com.example.springbootwithpostgressql.request;

import com.example.springbootwithpostgressql.common.HeaderInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BaseAuthRequest {

    @JsonIgnore
    protected HeaderInfo info;
}
