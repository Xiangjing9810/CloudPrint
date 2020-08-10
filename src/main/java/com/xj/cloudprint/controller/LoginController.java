package com.xj.cloudprint.controller;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.service.UserService;
import com.xj.cloudprint.util.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/2/9 21:00
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    ResultUtil res;
    @Value("${app.appid}")
    String appid;
    @Value("${app.secret}")
    String secret;
    @Value("${app.wechatUrl}")
    String url;
    private static final Logger logger = Logger.getLogger(LoginController.class);

    /**
     * 用户登录
     *
     * @param session
     * @param code
     * @return
     */
    @PostMapping(value = "/login")
    public ResultUtil login(HttpSession session,
                            @RequestParam(value = "code") String code) {
        User user;
        try {
            user = getUserByCode(code);
        } catch (RuntimeException ex) {
            logger.error(ex.getMessage() + "微信服务器返回数据错误");
            return ResultUtil.error(ex.getMessage() + "微信服务器返回数据错误");
        }
        logger.info("用户登录id :" + user.getOpenId());
        logger.info("用户登录sessionId :" + session.getId());
        user.setSessionId(session.getId());
        return userService.userLogin(user, session);

    }

    /**
     * 请求微信后台获取openid和sessionkey
     *
     * @param code
     * @return
     */
    private User getUserByCode(String code) throws RuntimeException {
        if (code.isEmpty()) {
            throw new RuntimeException("code is empty");
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("appid", appid);
            map.put("secret", secret);
            map.put("js_code", code);
            map.put("grant_type", "authorization_code");
            String str = HttpRequest.sendGet(url, map);
            JSONObject json = JSON.parseObject(str);
            String openid = (String) json.get("openid");
            String session = (String) json.get("session_key");
            if (openid.isEmpty()) {
                throw new RuntimeException("openid is empty");
            } else {
                User user = new User();
                user.setOpenId(openid);
                user.setSessionKey(session);
                return user;
            }
        }
    }


}
