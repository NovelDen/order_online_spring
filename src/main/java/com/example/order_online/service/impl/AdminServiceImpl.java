package com.example.order_online.service.impl;

import com.example.order_online.dao.AdminDao;
import com.example.order_online.domain.Admin;
import com.example.order_online.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    public List<Admin> getAll(){return adminDao.getAll();}
    public Admin login(String account,String password){
        Admin admin = adminDao.login(account,password);
        return admin;
    }
    public boolean updateAdmin(Admin admin){
        if (admin.getPassword()!=null){
            return adminDao.updatePassword(admin);
        }else {
            return adminDao.updateAdmin(admin);
        }
    }
    public Admin getAdminById(Integer id){
        return adminDao.getAdminById(id);
    }
}
