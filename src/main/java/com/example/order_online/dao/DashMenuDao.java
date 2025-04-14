package com.example.order_online.dao;

import com.example.order_online.queryEntity.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DashMenuDao{
    @Select("SELECT \n"+
            "c.categoryId AS categoryId,\n"+
            "c.categoryName AS categoryName, \n"+
            "c.description AS categoryDescription, \n"+
            "m.menuId AS menuId, \n"+
            "m.menuName AS menuName, \n"+
            "m.price AS price, \n"+
            "m.description AS menuDescription, \n"+
            "m.imagePath AS imagePath\n"+
            "FROM DashType c \n"+
            "Inner JOIN dashmenu m ON c.categoryId = m.categoryId \n"+
            "ORDER BY m.menuId;")
    public List<CategoryWithMenus> getAllDashMenu();
    @Select("select * from dashmenu where categoryId = #{id}")
    public List<DashMenu> getDashMenuByType(int id);
//    添加item
    @Insert("insert into dashmenu (id,name,description,price) values (#{id},#{name},#{description},#{price})")
    public Boolean addDashMenu(DashMenu dashmenu);
    @Update("update dashmenu set name = #{name}, description = #{discription}, price = #{price} where id = #{id}")
    public Boolean updateDashMenu(DashMenu item);
    @Delete("delete from dashmenu where menuId = #{id}")
    public Boolean deleteDashMenu(Integer id);
}
