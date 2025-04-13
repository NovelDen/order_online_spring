package com.example.order_online.domain;

import lombok.Data;

@Data
public class DashMenu {
    private int menuId;
    private String menuName;
    private int categoryId;
    private float price;
    private String description;
    private String imagePath;
}
