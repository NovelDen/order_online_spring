package com.example.order_online.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    @JsonProperty("uId")
    private Integer uId;

    @JsonProperty("uAccount")
    private String uAccount;

    @JsonProperty("uName")
    private String uName;

    @JsonProperty("uPassword")
    private String uPassword;

    @JsonProperty("uAvatar")
    private String uAvatar;

    @JsonProperty("Token")
    private String Token;
}
