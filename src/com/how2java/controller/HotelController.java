package com.how2java.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.Constant;
import com.how2java.mapper.HotelMapper;
import com.how2java.pojo.Hotel;
import com.how2java.pojo.JsonResponse;
import com.how2java.pojo.Room;
import com.how2java.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Logger;

@RequestMapping("/hotel")
@Controller
public class HotelController {
    Logger logger = Logger.getLogger(HotelController.class.getSimpleName());

    @Autowired
    HotelService hotelService;


    @RequestMapping(value = "/getListByType", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<List<Hotel>> getListByType(int page, int type) {
        int offset = (page - 1) * 5;
        PageHelper.offsetPage(offset, 5);
        List<Hotel> hotels = hotelService.getListByType(type);
        return new JsonResponse<>(200, Constant.SUCCESS, hotels);
    }

    /**
     * 获取单个酒店的信息
     *
     * @param hotelId
     * @return
     */
    @RequestMapping(value = "/getHotelById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<Hotel> getHotelById(int hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        if (hotel == null) {
            return new JsonResponse<>(400, "没有该酒店");
        }
        return new JsonResponse<>(200, Constant.SUCCESS, hotel);
    }

    /**
     * 根据酒店名字，地址 查询酒店
     *
     * @param searchContent
     * @return
     */
    @RequestMapping(value = "/searchHotel", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResponse<List<Hotel>> searchHotel(String searchContent) {
        if (searchContent == null || searchContent.equals("")) {
            return new JsonResponse<>(200, "查询内容为空");
        }
        List<Hotel> list = hotelService.SearchHotel(searchContent);
        if (list == null || list.size() == 0) {
            return new JsonResponse<>(400, "没找到该酒店");
        }
        return new JsonResponse<>(200, "获取成功", list);
    }
}
