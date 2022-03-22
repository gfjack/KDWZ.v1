package com.company.management_system.utils;

import com.company.management_system.exception.CommonException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

public class CommonUtils {

    public static boolean isValidCompanyType(Integer i) {
        if (null == i) {
            return false;
        }

        return i >= 1 && i <= 3;
    }

    public static void validateTime(Date startTime, Date endTime) {
        if (null == startTime && null == endTime) {
            return;
        }
        if (null == startTime) {
            throw new CommonException("请输入开始时间");
        }
        if (null == endTime) {
            throw new CommonException("请输入结束时间");
        }
        if (startTime.after(endTime)) {
            throw new CommonException("结束时间不能早于开始时间");
        }
    }


    public static void validateCompanyType(String companyName, Integer companyType) {
        if (companyName == null && companyType == null) {
            return;
        }
        if (null == companyType || null == companyName) {
            throw new CommonException("请输入单位名称或者类型");
        }
    }
}
