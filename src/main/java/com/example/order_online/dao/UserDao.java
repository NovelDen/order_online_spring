package com.example.order_online.dao;

import com.example.order_online.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("SELECT * FROM user ")
    public List<User> getAllUser();
    @Select("select * from user where uAccount = #{account} and uPassword = #{password}")
    public User login(String account,String password);
    @Select("select * from user where uName like CONCAT('%', #{name}, '%')")
    public List<User> getUserByName(String name);
    @Select("select * from user where uAccount = #{uAccount}")
    public User getUserByAccount(String uAccount);
    //    添加item
    @Insert("insert into user (uAccount,uName,uPassword,uAvatar) values (#{uAccount},#{uName},#{uPassword},#{uAvatar})")
    public Boolean addUser(User user);
    @Update("update user set uAccount = #{uAccount}, uName = #{uName}, uPassword = #{uPassword}, uAvatar = #{uAvatar} where uId = #{uId}")
    public Boolean updateUser(User user);
    @Delete("delete from user where uId = #{id}")
    public Boolean deleteUser(Integer id);
}
