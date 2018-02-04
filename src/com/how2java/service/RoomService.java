package com.how2java.service;

import com.how2java.pojo.Room;

import java.util.List;

public interface RoomService extends BaseService<Room> {
    List<Room> getRoomsByHotelId(Integer hotelId);
}
