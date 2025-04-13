package com.example.order_online;

import com.example.order_online.dao.DashMenuDao;
import com.example.order_online.dao.AdminDao;
import com.example.order_online.domain.Admin;
import com.example.order_online.domain.DashMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderOnlineApplicationTests {
    @Autowired
    private DashMenuDao dashMenuDao;
    @Autowired
    private AdminDao adminDao;
    @Test
    void testgetbyType() {
        List<DashMenu> item = dashMenuDao.getDashMenuByType(1);
        System.out.println(item);
    }
    @Test
    void addItem(){
        DashMenu item = new DashMenu();
        item.setMenuName("测试商品");
        item.setMenuId(2);
        item.setDescription("测试商品描述");
        item.setPrice(100);
        Boolean res = dashMenuDao.addDashMenu(item);
        System.out.println(res);
    }
    @Test
    void testgetAll() {
        // 从itemDao中获取所有数据
        List<DashMenu> items = dashMenuDao.getAllDashMenu();
        // 打印获取到的数据
        System.out.println(items);
    }
    @Test
    void testlogin(){
        Admin admin = adminDao.login("tch2333","2320653.");
        System.out.println(admin);
    }

}
