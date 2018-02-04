package com.how2java.service;

import com.how2java.pojo.Hotel;

import java.util.List;

public interface HotelService extends BaseService<Hotel> {
    List<Hotel> getListByType(int type);

    Hotel getHotelById(int hotelId);

    List<Hotel> SearchHotel(String search);
}
