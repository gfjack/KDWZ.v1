package com.company.management_system.utils;

import java.util.Calendar;
import java.util.Date;

public class OrderUtils {

    public static String generateOrderNum(Date date, Integer num) {
        StringBuilder orderNum = new StringBuilder("");
        orderNum.append("KDWZ");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        orderNum.append(c.get(Calendar.YEAR));
        orderNum.append(c.get(Calendar.MONTH) + 1);
        orderNum.append(c.get(Calendar.DAY_OF_MONTH));

        orderNum.append("N");
        orderNum.append(num + 1);

        return orderNum.toString();
    }
}
