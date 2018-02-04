package com.how2java.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String yyyyMMddHHmmss = "yyyy-MM-dd- HH:mm:ss";

    public static String parseToDate(Date date, String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(style);
        String strDate = simpleDateFormat.format(date);
        return strDate;
    }
}