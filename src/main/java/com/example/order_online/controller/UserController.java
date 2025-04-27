package com.example.order_online.controller;

import com.example.order_online.common.Constants;
import com.example.order_online.common.Result;
import com.example.order_online.domain.Admin;
import com.example.order_online.domain.User;
import com.example.order_online.service.UserService;
import com.example.order_online.utils.JWTutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public Result getAllUser(){
        return Result.success(userService.getAllUser());
    }
    @GetMapping("/{name}")
    public Result getUserByName(@PathVariable String name){
        return Result.success(userService.getUserByName(name));
    }
    @GetMapping("/login")
    public Result login(@RequestParam String account, @RequestParam String password){
        User user = userService.login(account,password);
        if (user !=null){
            String userId = String.valueOf(user.getUId());
            String Token = JWTutils.getToken(userId,user.getUPassword());
            user.setUPassword("");
            user.setToken(Token);
            return Result.success(user);
        }else {
            return Result.error(Constants.CODE_600,"账号或密码错误");
        }
    }
    @GetMapping("/account")
    public Result getUserByAccount(@RequestParam String uAccount){
        return Result.success(userService.getUserByAccount(uAccount));
    }
    @PutMapping
    public Result addUser(@RequestBody User user){
        if (user.getUName()==null || user.getUPassword()==null || user.getUAccount() == null){
            return Result.error(Constants.CODE_400,"用户名、密码、账号不能为空");
        }
        if (userService.addUser(user)){
            return Result.success("添加成功");
        }
        else {
            return Result.error(Constants.CODE_400,"账号已存在");
        }
    }
    @PutMapping("/regist")
    public Result registUser(@RequestBody User user){
        if (user.getUName()==null || user.getUPassword()==null || user.getUAccount() == null){
            return Result.error(Constants.CODE_400,"用户名、密码、账号不能为空");
        }
        if (userService.addUser(user)){
            User user1 = userService.login(user.getUAccount(),user.getUPassword());
            String userId = String.valueOf(user1.getUId());
            String Token = JWTutils.getToken(userId,user1.getUPassword());
            user1.setUPassword("");
            user1.setToken(Token);
            return Result.success(user1);
        }
        else {
            return Result.error(Constants.CODE_400,"账号已存在");
        }
    }
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id){

        if (userService.deleteUser(id)){
            return Result.success("删除成功");
        }
        else {
            return Result.error();
        }
    }
    @PostMapping
    public Result updateUser(@RequestBody User user){
        if (userService.updateUser(user)){
            return Result.success("更新成功");
        }
        else {
            return Result.error();
        }
    }
}
