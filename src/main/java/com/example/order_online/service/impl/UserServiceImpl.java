package com.example.order_online.service.impl;

import com.example.order_online.dao.DashTypeDao;
import com.example.order_online.dao.UserDao;
import com.example.order_online.domain.DashType;
import com.example.order_online.domain.User;
import com.example.order_online.service.DashTypeService;
import com.example.order_online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDao;
    public User login(String account,String password){
        return UserDao.login(account,password);
    };
    public List<User> getAllUser() {
        return UserDao.getAllUser();
    }
    public boolean getUserByAccount(String account){
        User user = UserDao.getUserByAccount(account);
        if (user!=null){
            return true;
        }else {
            return false;
        }
    }

    public boolean addUser(User user) {
        if (UserDao.getUserByAccount(user.getUAccount())!=null){
            return false;
        }
        return UserDao.addUser(user);
    }

    public List<User> getUserByName(String name) {
        return UserDao.getUserByName(name);
    }
    public boolean updateUser(User user) {
        return UserDao.updateUser(user);
    }
    public boolean deleteUser(int id) {
        return UserDao.deleteUser(id);
    }
}
