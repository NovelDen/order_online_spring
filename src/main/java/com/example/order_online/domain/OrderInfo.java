package com.example.order_online.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderInfo {
    @JsonProperty("orderInfoId")
    private Integer orderInfoId;
    @JsonProperty("orderId")
    private Integer orderId;
    @JsonProperty("menuId")
    private Integer menuId;
    @JsonProperty("menuName")
    private String menuName;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("description")
    private String description;
    @JsonProperty("imagePath")
    private String imagePath;
    @JsonProperty("price")
    private Float price;
}
