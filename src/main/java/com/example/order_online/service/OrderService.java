package com.example.order_online.service;

import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.Order;
import com.example.order_online.domain.OrderInfo;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public List<Order> getOrderByUserId(Integer uId);
    public Order getOrderById(Integer orderId);
    public boolean addOrderMenu(OrderInfo orderInfo);
    boolean processPayment(Integer orderId, String paymentMethod);
    public boolean updateStatus(Order order);
    public Order createOrder(Integer uId, List<OrderInfo> menus);
    public boolean updateOrderMenu(OrderInfo orderInfo);
    public boolean deleteOrderMenu(Integer orderInfoId);
    public boolean deleteOrder(Integer orderId);
}
