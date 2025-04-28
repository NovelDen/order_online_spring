package com.example.order_online.dao;

import com.example.order_online.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {
    @Select("SELECT * FROM comment inner join user on comment.uId = user.uId inner join dashmenu on comment.menuId = dashmenu.menuId")
    public List<Comment> getAllComment();
    @Select("SELECT * FROM comment inner join user on comment.uId = user.uId inner join dashmenu on comment.menuId = dashmenu.menuId where user.uName like CONCAT('%', #{uName}, '%') and dashmenu.menuName like CONCAT('%', #{menuName}, '%') order by comment.commentTime desc")
    public List<Comment> getCommentByQeury(Comment comment);
    @Select("<script>" +
            "SELECT * FROM comment " +
            "INNER JOIN user ON comment.uId = user.uId " +
            "INNER JOIN dashmenu ON comment.menuId = dashmenu.menuId " +
            "WHERE 1=1 " +
            "<if test='uId != null'> AND comment.uId = #{uId} </if>" +
            "<if test='menuId != null'> AND comment.menuId = #{menuId} </if>" +
            "order by comment.commentTime desc " +
            "</script>")
    public List<Comment> getCommentByQeuryId(Comment comment);
    //    添加item
    @Insert("insert into comment (uId,menuId,rating,commentText) values (#{uId},#{menuId},#{rating},#{commentText})")
    public Boolean addComment(Comment comment);
    @Update("update comment set rating = #{rating}, commentText = #{commentText} where commentId = #{commentId}")
    public Boolean updateComment(Comment comment);
    @Delete("delete from comment where commentId = #{commentId}")
    public Boolean deleteComment(Integer id);
}
