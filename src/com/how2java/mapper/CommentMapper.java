package com.how2java.mapper;

import com.how2java.base.BaseMapper;
import com.how2java.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> getCommentByHotelId(@Param("hotelId") int hotelId);

    int postComment(Comment comment);
}
