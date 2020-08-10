package com.xj.cloudprint.service.impl;

import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.mapper.UserMapper;
import com.xj.cloudprint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ResultUtil userLogin(User user, HttpSession session) {
        assert user != null;
        //查询用户是否存在
        User u = userMapper.selectByPrimaryKey(user.getOpenId());
        Map<String, String> map = new HashMap<>();
        if (u != null) {
            //存在用户
            session.setAttribute("user",u);
            int result = userMapper.updateByPrimaryKey(user);
            if (result == 1) {
                map.put("sessionId", user.getSessionId());
                return ResultUtil.success(map);
            } else {
                return ResultUtil.error(null);
            }
        } else {
            //插入用户
            session.setAttribute("user",user);
            int result = userMapper.insertSelective(user);
            if (result == 1) {
                map.put("sessionId", user.getSessionId());
                return ResultUtil.success(map);

            } else {
                return ResultUtil.error(null);
            }
        }
    }
}
