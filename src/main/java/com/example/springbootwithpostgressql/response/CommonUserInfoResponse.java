package com.example.springbootwithpostgressql.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonUserInfoResponse {
    private String hoTen;
    private String chucVu;
    private String donVi;
    private String email;
    private String userName;
    private String soDienThoai;
}
