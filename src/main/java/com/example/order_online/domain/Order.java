package com.example.order_online.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    @JsonProperty("orderId")
    private Integer orderId;
    @JsonProperty("uId")
    private Integer uId;
    @JsonProperty("uName")
    private String uName;
    @JsonProperty("totalAmount")
    private Float totalAmount;
    @JsonProperty("status")
    private String status;
    @JsonProperty("orderTime")
    private String orderTime;
    @JsonProperty("orderInfo")
    private List<OrderInfo> orderInfo;
}
