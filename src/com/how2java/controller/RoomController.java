package com.how2java.controller;

import com.github.pagehelper.PageHelper;
import com.how2java.Constant;
import com.how2java.mapper.RoomMapper;
import com.how2java.pojo.JsonResponse;
import com.how2java.pojo.Room;
import com.how2java.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/room")
@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/getRoomsByHotelId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<List<Room>> getRoomsByHotelId(Integer hotel_id,Integer page) {
        int offset = (page - 1) * 5;
        if (hotel_id == null) {
            return new JsonResponse(401, "参数不能为空");
        }
        PageHelper.offsetPage(offset, 5);
        List<Room> roomList = roomService.getRoomsByHotelId(hotel_id);
        if (roomList == null || roomList.size() == 0) {
            return new JsonResponse(402, "该酒店没有房间");
        }
        return new JsonResponse(200, Constant.SUCCESS, roomList);
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<List<Room>> getRoomList(Integer page) {
        int offset = (page - 1) * 5;
        PageHelper.offsetPage(offset, 5);
        List<Room> roomList = roomService.list();
        return new JsonResponse<>(200, Constant.SUCCESS, roomList);
    }
}
