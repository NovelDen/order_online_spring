package com.example.order_online.queryEntity;

import lombok.Data;

@Data
public class CategoryWithMenus {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private Long menuId;
    private String menuName;
    private Float price;
    private String menuDescription;
    private String imagePath;
}
