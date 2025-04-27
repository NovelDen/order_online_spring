package com.example.order_online.controller;

import com.example.order_online.common.Constants;
import com.example.order_online.common.Result;
import com.example.order_online.domain.Admin;
import com.example.order_online.service.AdminService;
import com.example.order_online.utils.JWTutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping
    public List<Admin> getAllItems(){
        return adminService.getAll();
    }
    @GetMapping("/login")
    public Result login(@RequestParam String account, @RequestParam String password){
        Admin admin = adminService.login(account,password);
        if (admin !=null){
            String userId = String.valueOf(admin.getId());
            String userName = String.valueOf(admin.getAccount());
            String avatar = String.valueOf(admin.getAvatar());
            String Token = JWTutils.getToken(userId,admin.getPassword());
            Map<String, Object> data = new HashMap<>();
            data.put("userId", userId);
            data.put("userName", userName);
            data.put("token", Token);
            data.put("avatar",avatar);
            return Result.success(data);
        }else {
            return Result.error(Constants.CODE_600,"账号或密码错误");
        }
    }
    @PostMapping
    public Result updateAdmin(@RequestBody Admin admin){
        if (adminService.updateAdmin(admin)){
            Admin admin1 = adminService.getAdminById(admin.getId());
            admin1.setPassword("");
            return Result.success(admin1);
        }else{
            return Result.error(Constants.CODE_600,"修改失败");
        }
    }
}
