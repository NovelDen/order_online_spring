package com.example.order_online.service;

import com.example.order_online.domain.DashType;

import java.util.List;

public interface DashTypeService {
    public List<DashType> getAllDashType();
    public List<DashType> getDashTypeByName(String name);
    public boolean addDashType(DashType item);
    public boolean updateDashType(DashType item);
    public boolean deleteDashType(int id);
}
