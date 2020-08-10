package com.xj.cloudprint.service.impl;

import com.xj.cloudprint.config.common;
import com.xj.cloudprint.entity.Orders;
import com.xj.cloudprint.entity.SocketFile;
import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.entity.UserFile;
import com.xj.cloudprint.service.DeviceService;
import com.xj.cloudprint.service.OrderService;
import com.xj.cloudprint.service.SocketFileService;
import com.xj.cloudprint.util.SendFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


/**
 * 文件发送服务
 */
@Service
public class SendFileService {
    private static Logger logger = Logger.getLogger(SendFileService.class);
    @Autowired
    OrderService orderService;
    @Autowired
    DeviceService deviceService;
    @Autowired
    SocketFileService socketFileService;

    public void sendFile(User user, String oid){
        //获取订单
        List<Orders> ordersList = orderService.selectByPrimaryKey(oid);
        //获取当前订单的端口号
        int devicePort = deviceService.selectByPrimaryKey(ordersList.get(0).getDeviceId()).getDevicePort();
        for (Orders order:ordersList) {
            //获取订单中的文件
            UserFile userFile = order.getUserFile();
            //获取打印数据
            SocketFile socketFile = socketFileService.selectByPrimaryKey(userFile.getFileId());
            socketFile.setOpenId(user.getOpenId());
            //发送文件到指定端口
            SendFile.sendFile(socketFile, common.remoteAddress,devicePort);
            order.setOrderState("completeOrder");
            orderService.updateByPrimaryKeySelective(order);
            socketFile.setFileState("completeSend");
            socketFileService.updateByPrimaryKey(socketFile);
        }
    }
}

