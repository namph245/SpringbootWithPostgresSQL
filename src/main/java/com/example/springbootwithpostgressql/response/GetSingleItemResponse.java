package com.example.springbootwithpostgressql.response;

import lombok.Data;

@Data
public class GetSingleItemResponse<T> extends BaseResponse {

    protected T item;
}
