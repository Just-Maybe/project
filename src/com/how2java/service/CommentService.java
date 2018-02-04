package com.how2java.service;

import com.how2java.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService extends BaseService<Comment> {
    List<Comment> getCommentByHotelId(int hotelId);

    int postComment(Comment comment);
}
