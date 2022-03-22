package com.company.management_system.utils;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ErrorUtils {

    public static boolean checkIfNull(String s) {
        return !StringUtils.hasLength(s);
    }

    public static boolean checkIfNull(Long s) {
        return null == s;
    }

    public static boolean checkIfNull(Boolean b) {
        return null == b;
    }

    public static boolean checkIfNull(Date date) {
        return null == date;
    }

    public static boolean checkIfNull(List<String> l) {
        return null == l;
    }

    public static boolean checkIfNull(BigDecimal b) {
        return null == b;
    }
}
