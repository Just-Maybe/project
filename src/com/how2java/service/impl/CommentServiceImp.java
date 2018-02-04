package com.how2java.service.impl;


import com.how2java.mapper.CommentMapper;
import com.how2java.pojo.Comment;
import com.how2java.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByHotelId(int hotelId) {
        return commentMapper.getCommentByHotelId(hotelId);
    }

    @Override
    public int postComment(Comment comment) {
      return   commentMapper.postComment(comment);
    }

    @Override
    public List<Comment> list() {
        return null;
    }

    @Override
    public void insert(Comment comment) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Comment comment) {

    }

    @Override
    public Comment query(int id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
