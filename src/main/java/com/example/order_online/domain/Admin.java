package com.example.order_online.domain;

import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String account;
    private String password;
    private String Token;
}
