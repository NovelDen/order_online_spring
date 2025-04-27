package com.example.order_online.service;

import com.example.order_online.domain.Comment;
import com.example.order_online.domain.User;

import java.util.List;

public interface CommentService {
    public List<Comment> getAllComment();
    public List<Comment> getAllCommentByQuery(Comment comment);

    public boolean addComment(Comment comment);
    public boolean updateComment(Comment comment);
    public boolean deleteComment(int id);
}
