package com.manito.bill.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期时间工具类
 *
 * @author Administrator
 */
public class DateUtils {

    public static final SimpleDateFormat TIME_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat Month_FORMAT =
            new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat DATEKEY_FORMAT =
            new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat DATEKEY_FORMAT_MONTH =
            new SimpleDateFormat("yyyyMM");

    /**
     * 判断一个时间是否在另一个时间之前
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean before(String time1, String time2) {
        try {
            Date dateTime1 = TIME_FORMAT.parse(time1);
            Date dateTime2 = TIME_FORMAT.parse(time2);

            if (dateTime1.before(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之前
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean before(SimpleDateFormat myDATE_FORMAT,String time1, String time2) {
        try {
            Date dateTime1 = myDATE_FORMAT.parse(time1);
            Date dateTime2 = myDATE_FORMAT.parse(time2);

            if(dateTime1.before(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之后
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean after(String time1, String time2) {
        try {
            Date dateTime1 = TIME_FORMAT.parse(time1);
            Date dateTime2 = TIME_FORMAT.parse(time2);

            if (dateTime1.after(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 计算时间差值（单位为秒）
     *
     * @param time1 时间1
     * @param time2 时间2
     * @return 差值
     */
    public static int minus(String time1, String time2) {
        try {
            Date datetime1 = TIME_FORMAT.parse(time1);
            Date datetime2 = TIME_FORMAT.parse(time2);

            long millisecond = datetime1.getTime() - datetime2.getTime();

            return Integer.valueOf(String.valueOf(millisecond / 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取年月日和小时
     *
     * @param datetime 时间（yyyy-MM-dd HH:mm:ss）
     * @return 结果（yyyy-MM-dd_HH）
     */
    public static String getDateHour(String datetime) {
        String date = datetime.split(" ")[0];
        String hourMinuteSecond = datetime.split(" ")[1];
        String hour = hourMinuteSecond.split(":")[0];
        return date + "_" + hour;
    }

    /**
     * 获取当天日期（yyyy-MM-dd）
     *
     * @return 当天日期
     */
    public static String getTodayDate() {
        return DATE_FORMAT.format(new Date());
    }

    /**
     * 获取当月（yyyy-MM）
     *
     * @return 当天日期
     */
    public static String getNowMonth() {
        return DATE_FORMAT.format(new Date()).substring(0, 7);
    }

    /**
     * 获取昨天的日期（yyyy-MM-dd）
     *
     * @return 昨天的日期
     */
    public static String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date date = cal.getTime();

        return DATE_FORMAT.format(date);
    }

    /**
     * 获取上个月（yyyy-MM）
     *
     * @return 昨天的日期
     */
    public static String getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return Month_FORMAT.format(cal.getTime());
    }

    /**
     * 获取任意天数日期(-+)（yyyy-MM-dd）
     *
     * @return String
     */
    public static String getDate(int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, dayNum);

        Date date = cal.getTime();

        return DATE_FORMAT.format(date);
    }

    /**
     * 获取任意天数日期(-+)（yyyy-MM-dd）
     *
     * @return Date
     */
    public static Date getBeforeDate(int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, dayNum);

        Date date = cal.getTime();
        return date;
    }

    /**
     * 获取任意月(-+)（yyyyMM）
     *
     * @return
     */
    public static String getMonth(int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, dayNum);

        Date date = cal.getTime();

        return DATEKEY_FORMAT_MONTH.format(date);
    }

    /**
     * 获取任意月(-+)（yyyy-MM）
     *
     * @return
     */
    public static String getMonthT(int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, dayNum);

        Date date = cal.getTime();

        return Month_FORMAT.format(date);
    }

    /**
     * 获取昨天的时间（yyyy-MM-dd HH:mm:ss）
     *
     * @return 昨天的日期
     */
    public static String getYesterdayTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date date = cal.getTime();

        return TIME_FORMAT.format(date);
    }


    /**
     * 获取昨天的日期（yyyyMMdd）
     *
     * @return 昨天的日期
     */
    public static String getYesterdayDateyyMM() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date date = cal.getTime();

        return DATEKEY_FORMAT.format(date);
    }

    /**
     * 格式化日期（yyyy-MM-dd）
     *
     * @param date Date对象
     * @return 格式化后的日期
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }

    /**
     * 格式化时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param date Date对象
     * @return 格式化后的时间
     */
    public static String formatTime(Date date) {
        return TIME_FORMAT.format(date);
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm:ss）
     * @return 格式化后的时间
     */
    public static String getNowTime() {
        return TIME_FORMAT.format(new Date());
    }

    /**
     * 解析时间字符串
     *
     * @param time 时间字符串
     * @return Date
     */
    public static Date parseTime(String time) {
        try {
            if (time != null && !"".equals(time)) {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化日期key
     *
     * @param date
     * @return
     */
    public static String formatDateKey(Date date) {
        return DATEKEY_FORMAT.format(date);
    }

    /**
     * 格式化日期key
     *
     * @return
     */
    public static Date parseDateKey(String datekey) {
        try {
            return DATEKEY_FORMAT.parse(datekey);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化时间，保留到分钟级别
     * yyyyMMddHHmm
     *
     * @param date
     * @return
     */
    public static String formatTimeMinute(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return sdf.format(date);
    }

    /**
     * 获取当周的第一天和最后一天
     *
     * @param date
     * @return
     */
    public static List<String> getWeekRange(Date date) {
        List<String> weekDays = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        weekDays.add(imptimeBegin);
        weekDays.add(imptimeEnd);
        return weekDays;
    }

    /**
     * 获取某日期的周一
     *
     * @param num //num为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
     * @return
     */
    public static String getWeekMonSun(int num) {
        Calendar cal = Calendar.getInstance();
        int n = num;
        String monday;
        cal.add(Calendar.DATE, n * 7);
        //想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return monday;
    }

    /**
     * 获取一个月的第一天和最后一天
     *
     * @param num -+ num个月
     * @return
     */
    public static List<String> getMonthRange(int num) {
        List<String> monthDays = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, num);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = sdf.format(c.getTime());
        monthDays.add(first);

        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, num);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = sdf.format(ca.getTime());
        monthDays.add(last);
        return monthDays;
    }

    /**
     * 日期相减，得天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        long day = 0;
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date beginDate;
        java.util.Date endDate;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
            day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
            //System.out.println("相隔的天数="+day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static String editDays(String date, int day) {
        try {
            Date dt = threadLocal.get().parse(date);
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, day);
            String newDateStr = DATE_FORMAT.format(c.getTime());
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取指定日期的周一
     *
     * @return
     */
    public static String getMonday(String date) {
        try {
            Date dt = DATE_FORMAT.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            String monday;
            //想周几，这里就传几Calendar.MONDAY（TUESDAY...）
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            monday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
            return monday;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取指定日期的 +-n个月的第一天和最后一天
     * @param num -+ num个月
     * @return
     */
    public static List<String> getMonthRange(String date, int num) {
        try {
            List<String> monthDays = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //获取当前月第一天：
            Calendar c = Calendar.getInstance();
            Date dt = DATE_FORMAT.parse(date);
            c.setTime(dt);
            c.add(Calendar.MONTH, num);
            c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
            String first = sdf.format(c.getTime());
            monthDays.add(first);

            //获取当前月最后一天
            Calendar ca = Calendar.getInstance();
            ca.setTime(dt);
            ca.add(Calendar.MONTH, num);
            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
            String last = sdf.format(ca.getTime());
            monthDays.add(last);
            return monthDays;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static void main(String[] args) {
//		System.out.println(JSON.toJSONString(getWeekRange(new Date())));

//		long daySub = getDaySub("20171208", "20171107");
//		System.out.println(daySub);
//        String str = "20180919";
//        String str2 = "20180914";
//        List<String> l = new ArrayList<String>();
//
//        l.add(str);
//        l.add(str2);
//
//
////        System.out.println(str2<str);
//        System.out.println(str.substring(0,4));
//        System.out.println(str.substring(4,6));
//        System.out.println(str.substring(6,8));
//        System.out.println(StringUtils.isNotBlank(""));
//
//        System.out.println(27d/30);
//
//        System.out.println("2018-09-09".replace("-",""));
//        System.out.println(editDays("2018-10-06 ",-7).replace("-",""));
//        System.out.println(0L == 0);
//
//        System.out.println(getDaySub("2018-10-06","2018-10-10"));

//        System.out.println("20180906">"20180930");

        for (int i =0;i<500;i++){
            MyThread t = new MyThread();
            t.start();
        }

//        System.out.println(getTodayDate().replace("-",""));

    }
    static class MyThread extends Thread{
        public void run(){
            System.out.println(Thread.currentThread().getId());
            System.out.println(editDays("2018-10-06 ",-7).replace("-",""));
        }
    }

    public static String getFirstDayOfCurrentMonth() {
        LocalDate todaydate = LocalDate.now();
        LocalDate localDate = todaydate.withDayOfMonth(1);
        Date d = java.sql.Date.valueOf(localDate);
        String firstDay = DateUtils.format(d, "yyyy-MM-dd");
        return firstDay;
    }

    /**
     * 获取上月同一天
     */
    public static String getEditMonth(String date, int month) {
        Date dt = DateUtils.format(date, "yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, month);
        String newDateStr = DateUtils.format(c.getTime(), "yyyy-MM-dd");
        return newDateStr;
    }

    public static String format(Date date, String pattern) {
        if(date == null) {
            return "null";
        } else {
            if(pattern == null || pattern.equals("") || pattern.equals("null")) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }

            return (new SimpleDateFormat(pattern)).format(date);
        }
    }

    public static Date format(String date, String pattern) {
        if (pattern == null || pattern.equals("") || pattern.equals("null")) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        if (date != null && !date.equals("") && !date.equals("null")) {
            Date d = null;

            try {
                d = (new SimpleDateFormat(pattern)).parse(date);
            } catch (ParseException var4) {
                ;
            }

            return d;
        } else {
            return new Date();
        }
    }

}