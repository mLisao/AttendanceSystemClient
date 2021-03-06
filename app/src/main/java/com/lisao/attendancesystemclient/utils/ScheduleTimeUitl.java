package com.lisao.attendancesystemclient.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lisao on 2016/5/19.
 */
public class ScheduleTimeUitl {
    //开始上课时间
    //AM
    private final static String FRIST = "08:00:00";
    private final static String FRIST_END = "08:50:00";

    private final static String SECOND = "09:00:00";
    private final static String SECOND_END = "09:50:00";

    private final static String THIRD = "10:10:00";
    private final static String THIRD_END = "11:00:00";

    private final static String FOURTH = "11:10:00";
    private final static String FOURTH_END = "12:00:00";
    //PM
    private final static String FIFTH = "14:30:00";
    private final static String FIFTH_END = "15:20:00";

    private final static String SIXTH = "15:30:00";
    private final static String SIXTH_END = "16:20:00";

    private final static String SEVENTH = "16:40:00";
    private final static String SEVENTH_END = "17:30:00";

    private final static String EIGHTH = "17:40:00";
    private final static String EIGHTH_END = "18:20:00";

    private final static String NINTH = "18:40:00";
    private final static String NINTH_END = "19:30:00";

    private final static String TENTH = "19:40:00";
    private final static String TENTH_END = "20:30:00";

    private final static String ELEVENTH = "20:40:00";
    private final static String ELEVENTH_END = "21:30:00";

    private final static String TWELFTH = "21:40:00";
    private final static String TWELFTH_END = "22:30:00";

    private final static String TIME_FORMATE_STR = "HH:mm:ss";

    /**
     * 判断当前是第几节课
     *
     * @param timeMillis
     * @return
     */
    public static int getNum(long timeMillis) {
        Date date = new Date(timeMillis);
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMATE_STR);
        String currentTime = format.format(date);
        if (currentTime.compareTo(FRIST) >= 0 && currentTime.compareTo(FRIST_END) <= 0) {
            return 1;
        } else if (currentTime.compareTo(SECOND) >= 0 && currentTime.compareTo(SECOND_END) <= 0) {
            return 2;
        } else if (currentTime.compareTo(THIRD) >= 0 && currentTime.compareTo(THIRD_END) <= 0) {
            return 3;
        } else if (currentTime.compareTo(FOURTH) >= 0 && currentTime.compareTo(FOURTH_END) <= 0) {
            return 4;
        } else if (currentTime.compareTo(FIFTH) >= 0 && currentTime.compareTo(FIFTH_END) <= 0) {
            return 5;
        } else if (currentTime.compareTo(SIXTH) >= 0 && currentTime.compareTo(SIXTH_END) <= 0) {
            return 6;
        } else if (currentTime.compareTo(SEVENTH) >= 0 && currentTime.compareTo(SEVENTH_END) <= 0) {
            return 7;
        } else if (currentTime.compareTo(EIGHTH) >= 0 && currentTime.compareTo(EIGHTH_END) <= 0) {
            return 8;
        } else if (currentTime.compareTo(NINTH) >= 0 && currentTime.compareTo(NINTH_END) <= 0) {
            return 9;
        } else if (currentTime.compareTo(TENTH) >= 0 && currentTime.compareTo(TENTH_END) <= 0) {
            return 10;
        } else if (currentTime.compareTo(ELEVENTH) >= 0 && currentTime.compareTo(ELEVENTH_END) <= 0) {
            return 11;
        } else if (currentTime.compareTo(TWELFTH) >= 0 && currentTime.compareTo(TWELFTH_END) <= 0) {
            return 12;
        }
        return 1;
    }

    public static int getNum(String time) {
        Date date = new Date();
        DateFormat format = DateFormat.getTimeInstance();
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getNum(date.getTime());
    }

    public static String getTime(long timeMillis) {
        Date date = new Date(timeMillis);
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMATE_STR);
        return format.format(date);
    }

    public static void main(String[] args) {
        System.out.println(getNum("09:50:00"));
    }

}
