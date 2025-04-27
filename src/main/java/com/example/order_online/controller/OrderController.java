package com.example.order_online.controller;

import com.example.order_online.common.Constants;
import com.example.order_online.common.Result;
import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.Order;
import com.example.order_online.domain.OrderInfo;
import com.example.order_online.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public Result getAllOrder(){return Result.success(orderService.getAllOrders());}
    @GetMapping("/user")
    public Result getOrderByUserId(@RequestParam("uId") Integer uId){return Result.success(orderService.getOrderByUserId(uId));}
    @PostMapping
    public Result updateStatus(@RequestBody Order order){
        if (orderService.updateStatus(order)){
            return Result.success("更新成功");
        }else {
            return Result.error();
        }
    }
    @PostMapping("/menu")
    public Result updateOrderMenu(@RequestBody OrderInfo orderInfo){
        if (orderService.updateOrderMenu(orderInfo)){
            return Result.success("更新成功");
        }else {
            return Result.error();
        }
    }
    @PostMapping("/pay")
    public Result payOrder(@RequestBody Map<String, Object> params) {
        Integer orderId = (Integer) params.get("orderId");
        String paymentMethod = (String) params.get("paymentMethod");
        Order curOrder = orderService.getOrderById(orderId);
        if (curOrder.getStatus().equals("已支付")){
            return Result.error(Constants.CODE_600,"订单已支付");
        }
        try {
            // 调用支付服务
            boolean paymentResult = orderService.processPayment(orderId, paymentMethod);

            if (paymentResult) {
                // 更新订单状态为已支付
                Order order = new Order();
                order.setOrderId(orderId);
                order.setStatus("已支付");
                orderService.updateStatus(order);

                // 这里可以添加支付成功后的其他逻辑，如发送通知等

                return Result.success("支付成功");
            } else {
                return Result.error(Constants.CODE_600,"支付处理失败");
            }
        } catch (Exception e) {
            return Result.error(Constants.CODE_600,e.getMessage());
        }
    }
    @PutMapping("/menu")
    public Result addOrderMenu(@RequestBody OrderInfo orderInfo){
        if (orderService.addOrderMenu(orderInfo)){
            return Result.success("添加成功");
        }else {
            return Result.error();
        }
    }
    @PostMapping("/createOrder")
    public Result createOrder(@RequestParam("uId") Integer uId,@RequestBody List<OrderInfo> menus){
        Order order = orderService.createOrder(uId,menus);
        if (order.getOrderId() != null){
            return Result.success(order);
        }
        return Result.error();
    }
    @DeleteMapping("/menu/{orderInfoId}")
    public Result deleteOrderMenu(@PathVariable Integer orderInfoId) {
        System.out.println("orderInfoId:"+orderInfoId);
        if (orderService.deleteOrderMenu(orderInfoId)){
            return Result.success("删除成功");
        }else {
            return Result.error();
        }
    }
    @DeleteMapping("/{orderId}")
    public Result deleteOrder(@PathVariable Integer orderId){
        if (orderService.deleteOrder(orderId)){
            return Result.success("删除成功");
        }else {
            return Result.error();
        }
    }
}
