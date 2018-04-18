package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    int hour = cal.get(Calendar.HOUR_OF_DAY) ;
    cal.add(Calendar.DATE,-1); //得到上一天数据
    String queryDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    System.out.println(hour);
    System.out.println(queryDate);
}
}
