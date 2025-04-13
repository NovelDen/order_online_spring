package com.example.order_online.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.order_online.domain.DashMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DashMenuDao{
    @Select("select * from dashmenu")
    public List<DashMenu> getAllDashMenu();
    @Select("select * from dashmenu where categoryId = #{id}")
    public List<DashMenu> getDashMenuByType(int id);
//    添加item
    @Insert("insert into dashmenu (id,name,description,price) values (#{id},#{name},#{description},#{price})")
    public Boolean addDashMenu(DashMenu dashmenu);
    @Update("update dashmenu set name = #{name}, description = #{discription}, price = #{price} where id = #{id}")
    public Boolean updateDashMenu(DashMenu item);
    @Delete("delete from dashmenu where id = #{id}")
    public Boolean deleteDashMenu(Integer id);
}
