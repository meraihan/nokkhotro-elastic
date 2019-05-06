package com.proshomon.elasticsearch.nokkhotroelastic.utils;

import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.TimeZone;

public class Helper {
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public static ZoneId defaultZoneId = TimeZone.getDefault().toZoneId();

    public static LocalDateTime timeStampToLocalDateTime(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), defaultZoneId);
    }

    public static Date localDateToDate(LocalDateTime localDateTime){
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneOffset.systemDefault());
        Instant instant = zonedDateTime.toInstant();
        Date date = Date.from(instant);
        return date;
    }
}
