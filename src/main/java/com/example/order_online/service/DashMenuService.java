package com.example.order_online.service;

import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;

import java.util.List;

public interface DashMenuService {
    public List<CategoryWithMenus> getAllDashMenu();
    public boolean addDashMenu(DashMenu item);
    public List<DashMenu> getDashMenuByType(String name,Integer typeId);
    public boolean updateDashMenu(DashMenu item);
    public boolean deleteDashMenu(int id);
}
