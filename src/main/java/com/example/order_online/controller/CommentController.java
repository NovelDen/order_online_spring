package com.example.order_online.controller;

import com.example.order_online.common.Constants;
import com.example.order_online.common.Result;
import com.example.order_online.domain.Comment;
import com.example.order_online.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping
    public Result getAllComment(){
        return Result.success(commentService.getAllComment());
    }
    @GetMapping("/menu/{id}")
    public Result getAllCommentByMenuId(@PathVariable Integer id){
        Comment comment = new Comment();
        comment.setMenuId(id);
        return Result.success(commentService.getAllCommentByQueryId(comment));
    }
    @GetMapping("/user/{id}")
    public Result getAllCommentByUserId(@PathVariable Integer id){
        Comment comment = new Comment();
        comment.setUId(id);
        return Result.success(commentService.getAllCommentByQueryId(comment));
    }
    @PostMapping("/query")
    public Result getAllCommentByQuery(@RequestBody Comment comment){
        return Result.success(commentService.getAllCommentByQuery(comment));
    }
    @PutMapping
    public Result addComment(@RequestBody Comment comment){
        if (commentService.addComment(comment)){
            return Result.success("添加成功");
        }
        else {
            return Result.error(Constants.CODE_400,"添加失败");
        }
    }
    @DeleteMapping("/{id}")
    public Result deleteComment(@PathVariable Integer id){

        if (commentService.deleteComment(id)){
            return Result.success("删除成功");
        }
        else {
            return Result.error();
        }
    }
    @PostMapping
    public Result updateComment(@RequestBody Comment comment){
        if (commentService.updateComment(comment)){
            return Result.success("更新成功");
        }
        else {
            return Result.error();
        }
    }
}
