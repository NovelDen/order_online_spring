package com.example.order_online.dao;

import com.example.order_online.domain.DashType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DashTypeDao{
    @Select("SELECT * FROM DashType ")
    public List<DashType> getAllDashType();
    @Select("select * from dashmenu where categoryName like #{name}")
    public List<DashType> getDashTypeByName(String name);
    //    添加item
    @Insert("insert into dashmenu (id,name,description,price) values (#{id},#{name},#{description},#{price})")
    public Boolean addDashType(DashType dashmenu);
    @Update("update dashmenu set name = #{name}, description = #{discription}, price = #{price} where id = #{id}")
    public Boolean updateDashType(DashType item);
    @Delete("delete from dashmenu where menuId = #{id}")
    public Boolean deleteDashType(Integer id);
}
