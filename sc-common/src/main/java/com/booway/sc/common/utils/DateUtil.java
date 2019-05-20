package com.booway.sc.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
public class DateUtil
{
    public static final String TIMEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将日期格式化为String
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format)
    {
        if (date == null)
        {
            date = new Date();
        }
        if (StringUtil.isEmpty(format))
        {
            format = TIMEFORMAT;
        }
        return new SimpleDateFormat(format).format(date);
    }
}