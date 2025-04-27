package com.example.order_online.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.order_online.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminDao extends BaseMapper<Admin> {
    @Select("select * from admin")
    public List<Admin> getAll();
    @Select("select * from admin where account = #{account} and password = #{password}")
    public Admin login(String account, String password);
    @Select("select * from admin where id = #{id}")
    public Admin getAdminById(Integer id);
    @Update("update admin set account = #{account},avatar = #{avatar} where id = #{id}")
    public boolean updateAdmin(Admin admin);
    @Update("update admin set password = #{password} where id = #{id}")
    public boolean updatePassword(Admin admin);
}
