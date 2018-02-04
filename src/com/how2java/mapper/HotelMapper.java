package com.how2java.mapper;

import com.how2java.base.BaseMapper;
import com.how2java.pojo.Hotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotelMapper extends BaseMapper<Hotel> {
    List<Hotel> getListByType(@Param("type") int type);

    Hotel getHotelById(@Param("hotel_id") int hotelId);

    List<Hotel> searchHotel(@Param("search") String search);
}
