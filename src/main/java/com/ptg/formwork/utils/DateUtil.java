package com.ptg.formwork.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.ptg.formwork.constans.Constants.*;


/**
 * className: DateUtil
 * description: TODO
 *
 * @author hasee
 * @version 1.0
 * @date 2019/5/10 16:36
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static String transferDateToString(Date date, int i) {
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        if (i == 2) {
            sdf = new SimpleDateFormat(DATE_FORMAT2);
        } else if (i == 3) {
            sdf = new SimpleDateFormat(DATE_FORMAT3);
        } else if (i == 4) {
            sdf = new SimpleDateFormat(DATE_FORMAT4);
        }
        return sdf.format(date);
    }

    public static Date transferStringToDate(String str, int i) {
        Date date = new Date();
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            return date;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        if (i == 2) {
            sdf = new SimpleDateFormat(DATE_FORMAT2);
        } else if (i == 3) {
            sdf = new SimpleDateFormat(DATE_FORMAT3);
        } else if (i == 4) {
            sdf = new SimpleDateFormat(DATE_FORMAT4);
        }
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            logger.info(DATE_ERR);
        }
        return date;
    }
}
