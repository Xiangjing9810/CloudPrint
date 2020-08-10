package com.xj.cloudprint.controller;

import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.service.OrderService;
import com.xj.cloudprint.service.impl.SendFileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/1 23:54
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    SendFileService sendFileService;

    private static final Logger log = Logger.getLogger(OrderController.class);

    /**
     * 用户订单创建
     * @param session
     * @param deviceId
     * @return
     */
    @PostMapping("/generate")
    public ResultUtil order(HttpSession session,@RequestParam(value = "deviceId") String deviceId,
                                                @RequestParam(value = "fileType") String fileType) {
        String oid;
        User u = (User) session.getAttribute("user");
        try {
            oid = orderService.generateOrder(u.getOpenId(),fileType,deviceId);
        }catch (RuntimeException e){
            return ResultUtil.error("创建订单失败");
        }
        sendFileService.sendFile(u,oid);
        return ResultUtil.success("创建订单成功");
    }
}
