package com.example.order_online.controller;

import com.example.order_online.common.Result;
import com.example.order_online.domain.DashType;
import com.example.order_online.service.DashTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashType")
public class DashTypeController {
    @Autowired
    private DashTypeService dashTypeService;
    @GetMapping
    public Result getAllDashType(){
        return Result.success(dashTypeService.getAllDashType());
    }
    @GetMapping("/{name}")
    public Result getDashTypeByName(@PathVariable String name){
        return Result.success(dashTypeService.getDashTypeByName(name));
    }
    @PostMapping
    public Result addDashMenu(@RequestBody DashType item){
        if (dashTypeService.addDashType(item)){
            return Result.success("添加成功");
        }
        else {
            return Result.error();
        }
    }
    @DeleteMapping("/{id}")
    public Result deleteDashType(@PathVariable int id){
        if (dashTypeService.deleteDashType(id)){
            return Result.success("删除成功");
        }
        else {
            return Result.error();
        }
    }
    @PutMapping
    public Result updateDashMenu(@RequestBody DashType item){
        if (dashTypeService.updateDashType(item)){
            return Result.success("更新成功");
        }
        else {
            return Result.error();
        }
    }
}
