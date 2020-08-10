package com.xj.cloudprint.config;

import com.xj.cloudprint.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/22 22:53
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private String[] args = {"/login/login","/device/connection"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(args);
    }
}
