package com.example.order_online.dao;

import com.example.order_online.domain.Order;
import com.example.order_online.domain.OrderInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    @Select("SELECT * FROM orders o INNER JOIN user u ON o.uId = u.uId order by o.orderTime desc")
    @Results({
            @Result(property = "orderId", column = "orderId"),
            @Result(property = "uId", column = "uId"),
            @Result(property = "uName", column = "uName"),
            @Result(property = "totalAmount", column = "totalAmount"),
            @Result(property = "status", column = "status"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderInfo", column = "orderId", javaType = List.class, many = @Many(select = "com.example.order_online.dao.OrderDao.getOrderItemsByOrderId"))
    })
    public List<Order> getAllOrder();
    @Select("SELECT * FROM orders o INNER JOIN user u ON o.uId = u.uId where u.uId = #{uId} order by o.orderTime desc ")
    @Results({
            @Result(property = "orderId", column = "orderId"),
            @Result(property = "uId", column = "uId"),
            @Result(property = "uName", column = "uName"),
            @Result(property = "totalAmount", column = "totalAmount"),
            @Result(property = "status", column = "status"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderInfo", column = "orderId", javaType = List.class, many = @Many(select = "com.example.order_online.dao.OrderDao.getOrderItemsByOrderId"))
    })
    public List<Order> getOrderByUserId(Integer uId);
    @Select("SELECT * FROM orders o INNER JOIN user u ON o.uId = u.uId WHERE orderId = #{orderId}")
    @Results({
            @Result(property = "orderId", column = "orderId"),
            @Result(property = "uId", column = "uId"),
            @Result(property = "uName", column = "uName"),
            @Result(property = "totalAmount", column = "totalAmount"),
            @Result(property = "status", column = "status"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderInfo", column = "orderId", javaType = List.class, many = @Many(select = "com.example.order_online.dao.OrderDao.getOrderItemsByOrderId"))
    })
    public Order getOrderById(Integer orderId);
    @Select("SELECT * FROM orderinfo inner join dashmenu on orderinfo.menuId = dashmenu.menuId WHERE orderId = #{orderId}")
     public List<OrderInfo> getOrderItemsByOrderId(Integer orderId);
    @Select("SELECT SUM(oi.quantity * oi.price) FROM orderInfo oi WHERE oi.orderId = #{orderId}")
    public Float calculateTotalAmount(Integer orderId);
    @Update("UPDATE orders SET status = #{status} WHERE orderId = #{orderId}")
    public boolean updateStatus(Integer orderId,String status);
    @Insert("INSERT INTO payment_records (order_id, amount, payment_method, payment_time) " +
            "VALUES (#{orderId}, #{totalAmount}, #{paymentMethod}, NOW())")
    public boolean createPaymentRecord(Integer orderId,Float totalAmount,String paymentMethod);
    @Update("UPDATE orders SET totalAmount = #{totalAmount} WHERE orderId = #{orderId}")
    public boolean updateTotalAmount(Integer orderId,Float totalAmount);
    @Insert("INSERT INTO orders (uId,totalAmount,status) VALUES (#{uId},#{totalAmount},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    public boolean createOrder(Order order);
    @Insert("INSERT INTO orderinfo (orderId,menuId, quantity, price) VALUES (#{orderId},#{menuId}, #{quantity}, #{price})")
    public boolean addOrderMenu(OrderInfo orderInfo);
    @Update("UPDATE orderinfo SET menuId = #{menuId},quantity = #{quantity},price = #{price} WHERE orderInfoId = #{orderInfoId}")
    public boolean updateOrderMenu(OrderInfo orderInfo);
    @Delete("DELETE FROM orderinfo WHERE orderInfoId = #{orderInfoId}")
    public boolean deleteOrderMenu(Integer orderInfoId);
    @Delete("DELETE FROM orders WHERE orderId = #{orderId}")
    public boolean deleteOrder(Integer orderId);
}
