package com.how2java.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelPicture {
    private int id;
    private String picture;
    private int hotel_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "HotelPicture{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
