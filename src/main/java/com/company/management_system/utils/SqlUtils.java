package com.company.management_system.utils;

public class SqlUtils {

    public static String likeSearch(String param) {
        return null == param ? null : "%" + param + "%";
    }

}
