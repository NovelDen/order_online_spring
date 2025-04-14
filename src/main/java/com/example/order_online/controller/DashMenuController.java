package com.example.order_online.controller;

import com.example.order_online.queryEntity.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.service.DashMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashmenu")
public class DashMenuController {
    @Autowired
    private DashMenuService DashMenuService;
    @GetMapping
    public List<CategoryWithMenus> getAllDashMenu(){
        return DashMenuService.getAllDashMenu();
    }
    @GetMapping("/{id}")
    public List<DashMenu> getItemById(@PathVariable int id){
        return DashMenuService.getDashMenuByType(id);
    }
    @PostMapping
    public boolean addItem(@RequestBody DashMenu item){
        return DashMenuService.addDashMenu(item);
    }
    @DeleteMapping("/{id}")
    public boolean deleteItem(@PathVariable int id){
        return DashMenuService.deleteDashMenu(id);
    }
    @PutMapping
    public boolean updateItem(@RequestBody DashMenu item){
        return DashMenuService.updateDashMenu(item);
    }
}
