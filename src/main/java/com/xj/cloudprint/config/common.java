package com.xj.cloudprint.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/26 15:42
 */
public class common {
    @Value("${cloudPrint.Host}")
    public static String remoteAddress = "47.100.29.189";
}
