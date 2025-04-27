package com.example.order_online.dao;

import com.example.order_online.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    @Select("SELECT * FROM comment inner join user on comment.uId = user.uId inner join dashmenu on comment.menuId = dashmenu.menuId")
    public List<Comment> getAllComment();
    @Select("SELECT * FROM comment inner join user on comment.uId = user.uId inner join dashmenu on comment.menuId = dashmenu.menuId where user.uName like CONCAT('%', #{uName}, '%') and dashmenu.menuName like CONCAT('%', #{menuName}, '%')")
    public List<Comment> getCommentByQeury(Comment comment);
    //    添加item
    @Insert("insert into comment (uAccount,uName,uPassword,uAvatar) values (#{uAccount},#{uName},#{uPassword},#{uAvatar})")
    public Boolean addComment(Comment comment);
    @Update("update comment set uAccount = #{uAccount}, uName = #{uName}, uPassword = #{uPassword}, uAvatar = #{uAvatar} where uId = #{uId}")
    public Boolean updateComment(Comment comment);
    @Delete("delete from comment where uId = #{id}")
    public Boolean deleteComment(Integer id);
}
