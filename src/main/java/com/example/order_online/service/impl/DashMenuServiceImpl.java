package com.example.order_online.service.impl;

import com.example.order_online.dao.DashMenuDao;
import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.domain.DashType;
import com.example.order_online.service.DashMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashMenuServiceImpl implements DashMenuService {
    @Autowired
    private DashMenuDao DashMenuDao;
    public List<CategoryWithMenus> getAllDashMenu() {
        return DashMenuDao.getAllDashMenu();
    }
    public List<DashType> getAllDashMenuByType(){
        return DashMenuDao.getAllDashMenuByType();
    };

    public boolean addDashMenu(DashMenu dashMenu) {
        return DashMenuDao.addDashMenu(dashMenu);
    }

    public List<CategoryWithMenus> getDashMenuByType(String name,Integer typeId) {
        if(typeId != null){
            return DashMenuDao.getDashMenuByType(name,typeId);
        }else {
            return DashMenuDao.getDashMenuByName(name);
        }

    }
    public boolean updateDashMenu(DashMenu dashMenu) {
        return DashMenuDao.updateDashMenu(dashMenu);
    }
    public boolean deleteDashMenu(int id) {
        return DashMenuDao.deleteDashMenu(id);
    }
}
