package com.how2java.utils;


public class OrderNoUtil {
    public static long createOrderNo() {
        return (long) (100000000+(Math.random()*1000000000))-1;
    }
}
