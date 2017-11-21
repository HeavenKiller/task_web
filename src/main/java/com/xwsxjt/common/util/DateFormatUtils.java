package com.xwsxjt.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiaoshijie
 * @ClassName DateFormat
 * @Description 时间操作工具类
 * @date 2017/8/14
 */

public class DateFormatUtils {
    /**
     * 年月日格式
     */
    public static final String YEAR_MONTH_DAY="yyyy-MM-dd";
    /**
     * 年月日时分秒格式
     */
    public static final String YEAR_MONTH_DAY_HOU_MIN_SEC="yyyy-MM-dd HH:mm:ss";
    /**
     * 创建星期几数组，并初始化
     */
    private static final String[] WEEKS = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    /**
     * 创建月份数组，并初始化
     */
    private static final String[] MONTHS = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};

    /**
     * @Title: showDateByFormat
     * @Description: 指定时间转换为指定格式字符串
     * @author xiaoshijie
     * @date 2017-08-14
     * @param date
     * @param styleFormat
     * @return String
     */
    public static String showDateByFormat(Date date, String styleFormat){
        //判断用户输入的时间为空
        if (date == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = null;
        //判断用户是否输入时间格式
        if (styleFormat == null || styleFormat.equals("")){
            simpleDateFormat = new SimpleDateFormat(YEAR_MONTH_DAY);
        }else {
            simpleDateFormat = new SimpleDateFormat(styleFormat);
        }
        //创建字符串，并初始化
        String dateStr = null;
        //将指定时间转化为指定格式
        dateStr = simpleDateFormat.format(date);

        return dateStr;
    }

    /**
     * @Title: showDateByMoreFormat
     * @Description: 指定时间转换为指定格式的类型,并输出当月第几周星期几
     * @author xiaoshijie
     * @date 2017-08-14
     * @param date
     * @param styleFormat
     * @return String
     */
    public static String showDateByMoreFormat(Date date, String styleFormat){
        //判断用户输入的时间为空
        if (date == null){
            return null;
        }
        //创建字符串，并获得指定格式的时间字符串
        String dateStr = showDateByFormat(date, styleFormat);
        //创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        //用 date 来初始化 Calendar 对象
        calendar.setTime(date);
        //输出指定时间格式和当月第几周星期几
        System.out.println(dateStr
                +"; 当月第"+calendar.get(Calendar.WEEK_OF_MONTH)+"周"
                +WEEKS[calendar.get(Calendar.DAY_OF_WEEK)-1]);

        return dateStr;
    }

    /**
     * @Title: getDateByString
     * @Description: 字符串转化为时间
     * @author xiaoshijie
     * @date 2017-08-14
     * @param str
     * @return Date
     */
    public static Date getDateByString(String str, String styleFormat) throws ParseException {
        if (str == null || str.equals("")){
            return null;
        }

        try {
            //将字符串转化为时间并返回
            return (new SimpleDateFormat(styleFormat)).parse(str);
        } catch (ParseException e) {
            //抛出转化异常
            throw new ParseException(str + "不是时间格式，不能被转化", 85);
        }
    }

    /**
     * @Title: showMonthOfDate
     * @Description: 指定时间取指定时间的月份
     * @author xiaoshijie
     * @date 2017-08-14
     * @param date
     * @return String
     */
    public static String showMonthOfDate(Date date){
        if (date == null){
            return null;
        }
        //创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        //用 date 来初始化 Calendar 对象
        calendar.setTime(date);
        //获得指定月份：因为月份是从零开始的即零为一月
        return MONTHS[calendar.get(Calendar.MONTH)];
    }

    /**
     * @Title: getNewDateByAddValid
     * @Description: 获得新时间通过增加相应的天数
     * @author xiaoshijie
     * @date 2017-08-16
     * @param date
     * @param valid
     * @return Date
     */
    public static Date getNewDateByAddValid(Date date, int valid){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, valid);
        return calendar.getTime();
    }

    /**
     * @Title: getNewDateByDelValid
     * @Description: 获得新时间通过减去相应的天数
     * @author xiaoshijie
     * @date 2017-08-16
     * @param date
     * @param valid
     * @return Date
     */
    public static Date getNewDateByDelValid(Date date, int valid){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -valid);

        return calendar.getTime();
    }

    /**
     * @Title: getNewDateByAddSeconds
     * @Description: 获得距此时间多少秒的时间
     * @author xiaoshijie
     * @date 2017-08-18
     * @param date
     * @param seconds
     * @return Date
     */
    public static Date getNewDateByAddSeconds(Date date, int seconds){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);

        return calendar.getTime();
    }

    /**
     * @Title: getDateOfLastFriday
     * @Description: 指定时间取其上一周星期五的时间
     * @author xiaoshijie
     * @date 2017-08-14
     * @param date
     * @param styleFormat
     * @return Date
     */
    public static Date getDateOfLastFriday(Date date, String styleFormat){
        if (date == null){
            return null;
        }

        Date lastFriday = null;
        //创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();
        //用Date初始化Calendar对象
        calendar.setTime(date);

        //获取日期是本周的第几天，即星期几
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //根据星期差找到指定日期,如:上周星期天对应为1，这周星期一对应为2，以此类推，
        // 上周星期天距离上周星期五的天数差即为2，这周星期一到星期六距离上周星期五的天数差分别为：3至8
        //所以可得，天数差为：day+1
        calendar.add(Calendar.DATE, -(day+1));
        //返回上周星期五的时间
        lastFriday = calendar.getTime();
        //输出指定时间格式和当月第几周星期几
        showDateByMoreFormat(lastFriday, styleFormat);

        return lastFriday;
    }
}
