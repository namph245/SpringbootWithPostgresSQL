package com.example.springbootwithpostgressql.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private int role;
    private String createAt;
    private String updateAt;
    private Boolean isActive;
    private String createBy;
    private String updateBy;


}
