package com.example.order_online.service.impl;

import com.example.order_online.dao.CommentDao;
import com.example.order_online.domain.Comment;
import com.example.order_online.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    public List<Comment> getAllComment() {
        return commentDao.getAllComment();
    }

    public boolean addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    public List<Comment> getAllCommentByQuery(Comment comment) {
        return commentDao.getCommentByQeury(comment);
    }
    public List<Comment> getAllCommentByQueryId(Comment comment) {
        return commentDao.getCommentByQeuryId(comment);
    }
    public boolean updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }
    public boolean deleteComment(int id) {
        return commentDao.deleteComment(id);
    }
}
