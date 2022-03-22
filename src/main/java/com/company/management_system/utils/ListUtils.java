package com.company.management_system.utils;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {

    public static List<String> splitStringToList(String string) {
        if (!StringUtils.hasLength(string)) {
            return new ArrayList<>();
        }
        List<String> res = Arrays.asList(string.split(","));
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i).trim());
        }
        return res;
    }

    public static String ListToString(List<String> list) {
        return String.join(",", list);
    }

}
