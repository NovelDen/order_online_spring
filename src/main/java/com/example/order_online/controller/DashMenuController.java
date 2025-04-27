package com.example.order_online.controller;

import com.example.order_online.common.Result;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.service.DashMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/dashmenu")
public class DashMenuController {
    @Autowired
    private DashMenuService DashMenuService;
    @GetMapping
    public Result getAllDashMenu(){
        return Result.success(DashMenuService.getAllDashMenu());
    }
    @GetMapping("/type")
    public Result getAllDashMenuByType(){
        return Result.success(DashMenuService.getAllDashMenuByType());
    }
    @PostMapping("/dash")
    public Result getDashMenuByType(@RequestBody Map<String, Object> formData){
        String name = (String) formData.get("name");
        Integer typeId = (Integer) formData.get("type");
        return Result.success(DashMenuService.getDashMenuByType(name,typeId));
    }
    @PutMapping
    public Result addDashMenu(@RequestBody DashMenu item){
        if (DashMenuService.addDashMenu(item)){
            return Result.success("添加成功");
        }
        else {
            return Result.error();
        }
    }
    @DeleteMapping("/{id}")
    public Result deleteDashMenu(@PathVariable int id){
        if (DashMenuService.deleteDashMenu(id)){
            return Result.success("删除成功");
        }
        else {
            return Result.error();
        }
    }
    @PostMapping
    public Result updateDashMenu(@RequestBody DashMenu item){
        if (DashMenuService.updateDashMenu(item)){
            return Result.success("更新成功");
        }
        else {
            return Result.error();
        }
    }
}
