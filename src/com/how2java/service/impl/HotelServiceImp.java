package com.how2java.service.impl;

import com.how2java.mapper.HotelMapper;
import com.how2java.pojo.Hotel;
import com.how2java.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<Hotel> list() {
        return hotelMapper.list();
    }

    @Override
    public void insert(Hotel hotel) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public Hotel query(int id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public List<Hotel> getListByType(int type) {
        return hotelMapper.getListByType(type);
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelMapper.getHotelById(hotelId);
    }

    @Override
    public List<Hotel> SearchHotel(String search) {
        return hotelMapper.searchHotel(search);
    }
}
