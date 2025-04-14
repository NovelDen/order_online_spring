package com.example.order_online.service.impl;

import com.example.order_online.dao.DashTypeDao;
import com.example.order_online.domain.DashType;
import com.example.order_online.service.DashTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashTypeServiceImpl implements DashTypeService {
    @Autowired
    private DashTypeDao dashTypeDao;
    public List<DashType> getAllDashType() {
        return dashTypeDao.getAllDashType();
    }

    public boolean addDashType(DashType dashType) {
        return dashTypeDao.addDashType(dashType);
    }

    public List<DashType> getDashTypeByName(String name) {
        return dashTypeDao.getDashTypeByName(name);
    }
    public boolean updateDashType(DashType dashType) {
        return dashTypeDao.updateDashType(dashType);
    }
    public boolean deleteDashType(int id) {
        return dashTypeDao.deleteDashType(id);
    }
}
