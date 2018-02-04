package com.how2java.mapper;

import com.how2java.base.BaseMapper;
import com.how2java.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomMapper extends BaseMapper<Room> {
     List<Room> getRoomsByHotelId(@Param("hotel_id") Integer hotelId);

}
