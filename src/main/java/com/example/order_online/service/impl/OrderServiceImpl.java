package com.example.order_online.service.impl;

import com.example.order_online.dao.DashMenuDao;
import com.example.order_online.dao.OrderDao;
import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.domain.Order;
import com.example.order_online.domain.OrderInfo;
import com.example.order_online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private DashMenuDao dashMenuDao;
    public List<Order> getAllOrders() {
        return orderDao.getAllOrder();
    }
    public List<Order> getOrderByUserId(Integer uId){
        return orderDao.getOrderByUserId(uId);
    };
    public Order getOrderById(Integer orderId){
        return orderDao.getOrderById(orderId);
    }

    public boolean addOrderMenu(OrderInfo orderInfo) {
        DashMenu dashMenu = dashMenuDao.getDashMenuById(orderInfo.getMenuId());
        Float price = dashMenu.getPrice();
        orderInfo.setPrice(price * orderInfo.getQuantity());
        orderDao.addOrderMenu(orderInfo);
        Integer orderId = orderInfo.getOrderId();
        Float totalAmount = orderDao.calculateTotalAmount(orderId);
        if (!orderDao.updateTotalAmount(orderId, totalAmount)){
            throw new RuntimeException("更新订单总金额失败");
        }
        return true;
    }
    public boolean processPayment(Integer orderId, String paymentMethod) {
        Order order = orderDao.getOrderById(orderId);
        if (order == null) {
            throw new RuntimeException("订单不存在");
        }
        if (!"待支付".equals(order.getStatus())) {
            throw new RuntimeException("订单状态不允许支付");
        }

        // 模拟支付处理
        boolean paymentSuccess = simulatePayment(order.getTotalAmount(), paymentMethod);
        if (paymentSuccess) {
            return orderDao.createPaymentRecord(order.getOrderId(),order.getTotalAmount(),paymentMethod);
        }

        return false;
    }
    private boolean simulatePayment(Float amount, String paymentMethod) {
        return true;
    }
    public boolean updateStatus(Order order) {
        return orderDao.updateStatus(order.getOrderId(),order.getStatus());
    }

    public Order createOrder(Integer uId, List<OrderInfo> menus){
        Order order = new Order();
        order.setUId(uId);
        order.setTotalAmount(0.0f);
        order.setStatus("待支付");

        // 创建订单
        if (!orderDao.createOrder(order)) {
            throw new RuntimeException("创建订单失败");
        }

        // 计算总金额并添加订单项
        float totalAmount = 0.0f;
        for (OrderInfo item : menus) {
            if (item.getQuantity() > 0) {
                    // 计算单项总价
                    float itemTotal = item.getPrice() * item.getQuantity();
                    item.setOrderId(order.getOrderId());
                    item.setPrice(itemTotal);
                    totalAmount += itemTotal;
                    // 添加订单项
                    if (!orderDao.addOrderMenu(item)) {
                        throw new RuntimeException("添加订单项失败");}
            }
        }
        // 更新订单总金额
        order.setTotalAmount(totalAmount);
        if (!orderDao.updateTotalAmount(order.getOrderId(), totalAmount)) {
            throw new RuntimeException("更新订单总金额失败");
        }

        // 返回完整的订单信息
        return orderDao.getOrderById(order.getOrderId());
    };
    public boolean updateOrderMenu(OrderInfo orderInfo) {
        DashMenu dashMenu = dashMenuDao.getDashMenuById(orderInfo.getMenuId());
        Float price = dashMenu.getPrice();
        orderInfo.setPrice(price * orderInfo.getQuantity());
        orderDao.updateOrderMenu(orderInfo);
        Integer orderId = orderInfo.getOrderId();
        Float totalAmount = orderDao.calculateTotalAmount(orderId);
        System.out.println(totalAmount);
        if (!orderDao.updateTotalAmount(orderId, totalAmount)){
            throw new RuntimeException("更新订单总金额失败");
        }
        return true;
    }

    public boolean deleteOrderMenu(Integer orderInfoId) {
        System.out.println("deleteOrderMenu:orderInfoId:"+orderInfoId);
        return orderDao.deleteOrderMenu(orderInfoId);
    }
    public boolean deleteOrder(Integer orderId) {
        return orderDao.deleteOrder(orderId);
    }
}
