package Bishi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * data:2018-6-22
 * author:qixin
 * descriptor:日期常用方法
 * */
public class DateUtil {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat weekFormat = new SimpleDateFormat("yyyy-ww");

    private static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");



    /**
     * Turn date into week.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param day The date that needs to be converted into the week.
     * @return The week corresponding to the date or empty string.
     */
    public static String dayToWeek(String day) {
        try {
            Date date = dayFormat.parse(day);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            String year =  (new SimpleDateFormat("yyyy")).format(calendar.getTime());
            String week = String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
            return year + "-" + week;
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn date into month.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param day The date that needs to be converted into the month.
     * @return The month corresponding to the date or empty string.
     */
    public static String dayToMonth(String day) {
        try {
            Date date = dayFormat.parse(day);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return monthFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn first day of the week into day.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param week The week that needs to be converted into a day.
     * @return The day corresponding to first of the week or empty string.
     */
    public static String weekToFirstDay(String week) {
        try {
            Date date = weekFormat.parse(week);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.add(Calendar.DATE, 1);
            return dayFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn last day of the week into day.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param week The week that needs to be converted into a day.
     * @return The day corresponding to last day of the week or empty string.
     */
    public static String weekToLastDay(String week) {
        try {
            Date date = weekFormat.parse(week);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 7);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            return dayFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn week into month.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param week The week that needs to be converted into a month.
     * @return The month corresponding to the week or empty string.
     */
    public static String weekToMonth(String week) {
        try {
            Date date = weekFormat.parse(week);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            return monthFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn first day of the month into day.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param month The month that needs to be converted into a date.
     * @return The first day of the month or empty string.
     */
    public static String monthToFirstDay(String month) {
        try {
            Date date = monthFormat.parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return dayFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn last day of the month into day.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param month The month that needs to be converted into a date.
     * @return The last day of the month or empty string.
     */
    public static String monthToLastDay(String month) {
        try {
            Date date = monthFormat.parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            return dayFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn first week of the month into week.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param month The month that needs to be converted into a first week.
     * @return The first week of the month corresponding to the week or empty string.
     */
    public static String monthToFirstWeek(String month) {
        try {
            Date date = monthFormat.parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return weekFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * Turn last week of the month into week.
     * @author yinfuyuan <yinfuyuan@renrenche.com>
     * @param month The month that needs to be converted into a last week.
     * @return The last week of the month corresponding to the week or empty string.
     */
    public static String monthToLastWeek(String month) {
        try {
            Date date = monthFormat.parse(month);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            return weekFormat.format(calendar.getTime());
        } catch (ParseException pe) {
            return "";
        }
    }

    /**
     * 返回天数double类型
     * @author qixin
     * @param startTime,
     * @param endTime,
     * @return  返回天数double类型 天数小于1的都归为1（默认1天即汇总）
     */
    public static Double getDayNum(String startTime,String endTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Double dayNum=1.00d;
        try{
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(startTime));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(endTime));
            long time2 = cal.getTimeInMillis();
            long between_days=(time2-time1)/(1000*3600*24);
            if (between_days>1){
                String day=between_days+"";
                dayNum=Double.valueOf(day);
            }else {
                dayNum=1.00d;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return dayNum;
    }

}