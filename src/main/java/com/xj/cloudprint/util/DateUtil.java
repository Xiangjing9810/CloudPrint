package com.xj.cloudprint.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 返回14位时间，精确到秒
     * @return
     */
    public static String getNowDate(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(d);
    }

    /**
     * 根据类型返回不同id O-订单 F文件
     * @param tpye
     * @return
     */
    public static String getID(String tpye){
        return tpye +
                (System.currentTimeMillis() + "").substring(1) +
                (System.nanoTime() + "").substring(7, 10);
    }
}
