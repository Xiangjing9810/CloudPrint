package com.xj.cloudprint.service;

import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.entity.User;
import javax.servlet.http.HttpSession;

public interface UserService {


    ResultUtil userLogin(User user, HttpSession session);
}
