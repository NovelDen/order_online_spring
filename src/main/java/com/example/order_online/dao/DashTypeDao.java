package com.example.order_online.dao;

import com.example.order_online.domain.DashType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DashTypeDao{
    @Select("SELECT * FROM dashtype ")
    public List<DashType> getAllDashType();
    @Select("select * from dashtype where categoryName LIKE CONCAT('%', #{name}, '%')")
    public List<DashType> getDashTypeByName(String name);
    //    添加item
    @Insert("insert into dashtype (categoryName,description) values (#{categoryName},#{description})")
    public Boolean addDashType(DashType dashType);
    @Update("update dashtype set categoryName = #{categoryName}, description = #{description} where categoryId = #{categoryId}")
    public Boolean updateDashType(DashType item);
    @Delete("delete from dashtype where categoryId = #{id}")
    public Boolean deleteDashType(Integer id);
}
