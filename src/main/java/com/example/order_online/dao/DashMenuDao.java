package com.example.order_online.dao;

import com.example.order_online.domain.CategoryWithMenus;
import com.example.order_online.domain.DashMenu;
import com.example.order_online.domain.DashType;
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
            "WHERE m.menuName LIKE CONCAT('%', #{name}, '%') AND c.categoryId = #{typeId} \n"+
            "ORDER BY m.menuId;")
    public List<CategoryWithMenus> getDashMenuByType(String name,Integer typeId);
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
            "WHERE m.menuName LIKE CONCAT('%', #{name}, '%') \n"+
            "ORDER BY m.menuId;")
    public List<CategoryWithMenus> getDashMenuByName(String name);
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
            "WHERE c.categoryId = #{typeId} ")
    public List<CategoryWithMenus> getDashMenuByTypeId(Integer typeId);
    @Select("SELECT * FROM dashtype")
    @Results({
            @Result(property = "categoryId", column = "categoryId"),
            @Result(property = "categoryName", column = "categoryName"),
            @Result(property = "description", column = "description"),
            @Result(property = "dashMenus", column = "categoryId", javaType = List.class, many = @Many(select = "com.example.order_online.dao.DashMenuDao.getDashMenuByTypeId"))
    })
    public List<DashType> getAllDashMenuByType();
    @Select("select * from dashmenu where menuId = #{menuId}")
    public DashMenu getDashMenuById(Integer menuId);
//    添加item
    @Insert("insert into dashmenu (menuName,categoryId,price,description,imagePath) values (#{menuName},#{categoryId},#{price},#{description},#{imagePath})")
    public Boolean addDashMenu(DashMenu dashmenu);
    @Update("update dashmenu set menuName = #{menuName}, categoryId = #{categoryId}, price = #{price}, description = #{description}, imagePath = #{imagePath} where menuId = #{menuId}")
    public Boolean updateDashMenu(DashMenu dashmenu);
    @Delete("delete from dashmenu where menuId = #{id}")
    public Boolean deleteDashMenu(Integer id);
}
