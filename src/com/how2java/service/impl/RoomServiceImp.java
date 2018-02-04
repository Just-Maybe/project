package com.how2java.service.impl;

import com.how2java.mapper.RoomMapper;
import com.how2java.pojo.Room;
import com.how2java.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public List<Room> list() {
        return roomMapper.list();
    }

    @Override
    public void insert(Room room) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public Room query(int id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }


    @Override
    public List<Room> getRoomsByHotelId(Integer hotelId) {
        return roomMapper.getRoomsByHotelId(hotelId);
    }
}
