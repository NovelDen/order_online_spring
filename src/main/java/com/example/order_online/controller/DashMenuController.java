package com.example.order_online.controller;

import com.example.order_online.common.Result;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.service.DashMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dashmenu")
public class DashMenuController {
    @Autowired
    private DashMenuService DashMenuService;
    @GetMapping
    public Result getAllDashMenu(){
        return Result.success(DashMenuService.getAllDashMenu());
    }
    @GetMapping("/{id}")
    public Result getDashMenuByType(@PathVariable int id){
        return Result.success(DashMenuService.getDashMenuByType(id));
    }
    @PostMapping
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
    @PutMapping
    public Result updateDashMenu(@RequestBody DashMenu item){
        if (DashMenuService.updateDashMenu(item)){
            return Result.success("更新成功");
        }
        else {
            return Result.error();
        }
    }
}
