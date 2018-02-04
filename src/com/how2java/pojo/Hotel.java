package com.how2java.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Hotel {
    private int id;
    private String hotelName;
    private String address;
    private String area;
    private String introduce;
    private int type;       // 1为推荐   //2 为banner
    private List<HotelPicture> hotelImgUrl;
    private List<Room> roomList;

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<HotelPicture> getHotelImgUrl() {
        return hotelImgUrl;
    }

    public void setHotelImgUrl(List<HotelPicture> hotelImgUrl) {
        this.hotelImgUrl = hotelImgUrl;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotel_name='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", introduce='" + introduce + '\'' +
                ", type=" + type +
                ", hotelImgUrl=" + hotelImgUrl +
                '}';
    }
}
