package com.insider.travel.japan.wabisabi.serverlib.utils.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * Date utility class
 */
public class DateUtil {

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMM = "yyyyMM";
    public static final String HHmmssSSS = "HHmmssSSS";
    public static final String HHmmss = "HHmmss";

    public static Date parseDate(String str) {
        Date date;
        try {
            date = DateUtils.parseDate(str, yyyyMMddHHmmssSSS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        dateFormat.setTimeZone(calendar.getTimeZone());
        String timestamp = dateFormat.format(calendar.getTime());

        return DateUtil.parseDate(timestamp);
    }

    public static String getFormatedSystemDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yyyyMMddHHmmssSSS);
        return simpleDateFormat.format(new Date());
    }

    public static Date getDateFromFormatedString(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getDateFromFormatedString(Date date, String format, String timezone) {

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timezone));
        calendar.setTime(date);
        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setTimeZone(calendar.getTimeZone());

        return dateFormat.format(calendar.getTime());
    }

    public static Timestamp parseTimeStamp(String date) {
        Timestamp timestamp = null;
        try {
            timestamp = new Timestamp(new SimpleDateFormat(yyyyMMddHHmmssSSS).parse(date).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timestamp;
    }

    public static Date addMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);

        return calendar.getTime();
    }

    public static Date addDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);

        return calendar.getTime();
    }

    public static Date addMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);

        return calendar.getTime();
    }

    public static Date getEndOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        return calendar.getTime();
    }

    public static ZonedDateTime convertToZonedDateTime(Date date) {
        return ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Tokyo"));
    }

    public static ZonedDateTime convertToZonedDateTime(String yyyyMMddHHmmssSSS, ZoneId timezone) {
        return ZonedDateTime.of(Integer.parseInt(yyyyMMddHHmmssSSS.substring(0, 4)),
            Integer.parseInt(yyyyMMddHHmmssSSS.substring(4, 6)),
            Integer.parseInt(yyyyMMddHHmmssSSS.substring(6, 8)),
            Integer.parseInt(yyyyMMddHHmmssSSS.substring(8, 10)),
            Integer.parseInt(yyyyMMddHHmmssSSS.substring(10, 12)),
            Integer.parseInt(yyyyMMddHHmmssSSS.substring(12, 14)),
            Integer.parseInt(yyyyMMddHHmmssSSS.substring(14)), timezone);
    }

}
