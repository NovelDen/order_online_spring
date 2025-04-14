package com.example.order_online.service;

import com.example.order_online.queryEntity.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;

import java.util.List;

public interface DashMenuService {
    public List<CategoryWithMenus> getAllDashMenu();
    public boolean addDashMenu(DashMenu item);
    public List<DashMenu> getDashMenuByType(int id);
    public boolean updateDashMenu(DashMenu item);
    public boolean deleteDashMenu(int id);
}
