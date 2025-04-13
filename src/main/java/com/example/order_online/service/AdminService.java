package com.example.order_online.service;

import com.example.order_online.domain.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> getAll();
    public Admin login(String account, String password);
}
