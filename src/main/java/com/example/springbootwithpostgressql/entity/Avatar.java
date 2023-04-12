package com.example.springbootwithpostgressql.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Avatar {

    private String name;
    private String url;

}
