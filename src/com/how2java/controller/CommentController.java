package com.how2java.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.Constant;
import com.how2java.pojo.Comment;
import com.how2java.pojo.JsonResponse;
import com.how2java.service.CommentService;
import com.how2java.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@RequestMapping("/comment")
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/getCommentByHotelId")
    @ResponseBody
    public JsonResponse<List<Comment>> getCommentByHotelId(int hotelId, @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        if (page != 0) {
            int offset = (page - 1) * 5;
            PageHelper.offsetPage(offset, 5);
        }
        List<Comment> commentList = commentService.getCommentByHotelId(hotelId);
        if (commentList == null || commentList.size() == 0) {
            return new JsonResponse<>(401, "该酒店还没有评论");
        }
        return new JsonResponse<>(200, Constant.SUCCESS, commentList);
    }

    @RequestMapping("/postComment")
    @ResponseBody
    public JsonResponse<Void> postComment(String content, Integer userId, Integer hotelId) {
        if (content == null || userId == null || hotelId == null) {
            return new JsonResponse(400, "参数错误");
        }
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserId(userId);
        comment.setHotelId(hotelId);
        comment.setCreateTime(DateUtil.parseToDate(new Date(), DateUtil.yyyyMMddHHmmss));
        int isSuccess = commentService.postComment(comment);
        if (isSuccess > 0) {
            return new JsonResponse<>(200, "发送成功");
        }
        return new JsonResponse(401, "发送失败");
    }
}
