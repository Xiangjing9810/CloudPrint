package com.xj.cloudprint.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.xj.cloudprint.entity.ResultUtil;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author xj
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
			System.out.println(this.getClass().getName() + "拦截了" + req.getRequestURL());
			resp.setHeader("Content-type", "text/html;charset=UTF-8");
			PrintWriter out;
			out = resp.getWriter();
			out.append(JSONObject.toJSON(ResultUtil.error("用户未登陆", null)).toString());
			return false;
		}
		return true;
	}

}
