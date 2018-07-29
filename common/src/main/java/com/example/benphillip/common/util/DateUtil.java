package com.example.benphillip.common.util;

import android.support.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    /**
     * 英文简写如：2010
     */
    public static String FORMAT_Y = "yyyy";

    /**
     * 英文简写如：12:01
     */
    public static String FORMAT_HM = "HH:mm";

    /**
     * 英文简写如：1-12 12:01
     */
    public static String FORMAT_MDHM = "MM-dd HH:mm";

    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_YMD = "yyyy-MM-dd";

    /**
     * 英文全称  如：2010-12-01 23:15
     */
    public static String FORMAT_YMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 英文全称  如：2010-12-01 23:15:06
     */
    public static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 精确到毫秒的完整时间    如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL_SN = "yyyyMMddHHmmssS";

    /**
     * 中文简写  如：2010年12月01日
     */
    public static String FORMAT_YMD_CN = "yyyy年MM月dd日";

    /**
     * 中文简写  如：2010年12月01日  12时
     */
    public static String FORMAT_YMDH_CN = "yyyy年MM月dd日 HH时";

    /**
     * 中文简写  如：2010年12月01日  12时12分
     */
    public static String FORMAT_YMDHM_CN = "yyyy年MM月dd日 HH时mm分";

    /**
     * 中文全称  如：2010年12月01日  23时15分06秒
     */
    public static String FORMAT_YMDHMS_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

/*******************************String Date Calendar转换 start********************************/

    public static Date stringToDate(String str) {
        return stringToDate(str, null);
    }
    /**
     * 将一个日期字符串转换成Data对象
     * @param str	日期字符串
     * @param format		转换格式
     * @return	返回转换后的日期对象
     */

    public static Date stringToDate(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = DEFAULT_FORMAT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    public static Calendar stringToCalendar(String str) {
        return stringToCalendar(str, null);
    }

    /**
     * 将一个日期字符串转换成Calendar对象
     * @param str
     * @param format
     * @return
     */
    public static Calendar stringToCalendar(String str, String format) {

        Date date = stringToDate(str, format);
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c;
    }


    public static String calendarToString(Calendar c) {// yyyy-MM-dd HH:mm:ss
        return calendarToString(c, null);
    }

    /**
     * calendar 转换成字符串
     * @param c
     * @param format
     * @return
     */
    public static String calendarToString(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return dateToString(c.getTime(), format);
    }


    public static String dateToString(Date d) {// yyyy-MM-dd HH:mm:ss
        return dateToString(d, null);
    }

    /**
     * date 转换成字符串
     * @param d
     * @param format
     * @return
     */
    public static String dateToString(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = DEFAULT_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }
/*******************************String Date Calendar转换 end********************************/



/*******************************获取相关日期 start********************************/


    /**
     * 获得当前日期的字符串格式
     * @param format    格式化的类型
     * @return  返回格式化之后的事件
     */
    public static String getTodaytring(@Nullable String format) {
        Calendar c = Calendar.getInstance();
        return calendarToString(c, format);

    }


    public static String millisToString(long time) {

        return millisToString(time, DEFAULT_FORMAT);

    }

    /**
     * 毫秒转成字符串
     * @param time
     * @param format
     * @return
     */
    public static String millisToString(long time, String format) {
        return new SimpleDateFormat(format, Locale.CHINA).format(time);
    }





    /**
     * 功能描述：返回月
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     *
     * @return 当前月份
     */
    public static int getMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 功能描述：返回日
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     *
     * @return 当前日
     */
    public static int getDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     *
     * @return 当前小时
     */
    public static int getHour() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }
    public static int getMinute() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }


    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }
    public static int getSecond() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.SECOND);
    }



    /**
     * 功能描述：返回毫
     *
     * @param date 日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }
    public static long getMillis() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }







    /**
     * 在日期上增加数个整月
     * @param date 日期
     * @param n 要增加的月数
     * @return   增加数个整月
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();

    }


    /**
     * 在日期上增加天数
     * @param date 日期
     * @param n 要增加的天数
     * @return   增加之后的天数
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();

    }


    /**
     * 获取距现在某一小时的时刻
     *
     * @param format 格式化时间的格式
     * @param h 距现在的小时 例如：h=-1为上一个小时，h=1为下一个小时
     * @return  获取距现在某一小时的时刻
     */
    public static String getNextHour(String format, int h) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(date.getTime() + h * 60 * 60 * 1000);
        return sdf.format(date);

    }




    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return 按默认格式的字符串距离今天的天数
     */
    public static int countDays(String date) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date,DEFAULT_FORMAT));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;

    }


    /**
     * 使用用户格式提取字符串日期
     *2种字符串格式转换
     * @param strDate 日期字符串
     * @param format 日期格式
     * @return  提取字符串日期
     */
    public static Date parse(String strDate, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date 日期字符串
     * @param format 日期格式
     * @return  按用户格式字符串距离今天的天数
     */
    public static int countDays(String date, String format) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, format));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;

    }

    /**
     * 获取指定日期对应周几的序列
     * @param date	指定日期
     * @return	周一：1	周二：2	周三：3	周四：4	周五：5	周六：6	周日：7
     */
    public static int getIndexWeekOfDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_WEEK);
        if(index == 1){
            return 7;
        }else{
            return --index;
        }
    }

    /**
     * 获取指定月份的天数
     * @param year	年份
     * @param month	月份
     * @return	对应天数
     */

    public static int daysOfMonth(int year,int month){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if((year % 4 ==0 && year % 100 == 0) || year % 400 != 0){
                    return 29;
                }else{
                    return 28;
                }
            default:
                return -1;
        }
    }

}
