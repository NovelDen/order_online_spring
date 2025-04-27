package com.example.order_online.service;

import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.domain.DashType;

import java.util.List;

public interface DashMenuService {
    public List<CategoryWithMenus> getAllDashMenu();
    public boolean addDashMenu(DashMenu item);
    public List<CategoryWithMenus> getDashMenuByType(String name,Integer typeId);
    public boolean updateDashMenu(DashMenu item);
    public boolean deleteDashMenu(int id);
    public List<DashType> getAllDashMenuByType();
}
