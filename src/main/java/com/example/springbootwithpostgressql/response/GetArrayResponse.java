package com.example.springbootwithpostgressql.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
// kiểu generic nhận mọi đối tượng truyền vào
public class GetArrayResponse<T> extends BaseResponse {

    private long total;
    private List<T> rows;

    public GetArrayResponse() {
        super();
        this.total = 0;
        this.rows = new ArrayList<>();
    }

    public String info() {
        return "code = " + code + ", message = " + message + ", size = " + (rows != null ? rows.size() : 0) + ", total = " + total;
    }

    @Override
    public String baseInfo() {
        return this.info();
    }
}
