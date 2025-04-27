package com.example.order_online.service;

import com.example.order_online.domain.User;

import java.util.List;

public interface UserService {
    public User login(String account,String password);
    public List<User> getAllUser();
    public List<User> getUserByName(String name);
    public boolean getUserByAccount(String account);
    public boolean addUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(int id);
}
