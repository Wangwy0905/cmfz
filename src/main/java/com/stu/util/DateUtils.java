package com.stu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    public String getCurrMonthOnDay(){
        Calendar calender=Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        calender.add(Calendar.MONTH, 0);
        calender.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return format.format(calender.getTime());
    }

}
