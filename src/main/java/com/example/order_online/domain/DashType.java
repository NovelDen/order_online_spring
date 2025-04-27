package com.example.order_online.domain;

import lombok.Data;

import java.util.List;

@Data
public class DashType {
    private int categoryId;
    private String categoryName;
    private String description;
    private List<DashMenu> dashMenus;
}
