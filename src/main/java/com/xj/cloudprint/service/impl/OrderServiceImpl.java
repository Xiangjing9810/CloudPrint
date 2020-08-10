package com.xj.cloudprint.service.impl;

import com.xj.cloudprint.entity.Orders;
import com.xj.cloudprint.entity.UserFile;
import com.xj.cloudprint.mapper.OrdersMapper;
import com.xj.cloudprint.mapper.UserFileMapper;
import com.xj.cloudprint.service.OrderService;
import com.xj.cloudprint.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/1 23:52
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    UserFileMapper userFileMapper;
    private static final Logger log = Logger.getLogger(OrderServiceImpl.class);

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String generateOrder(String openId, String fileType,String deviceId) {
        UserFile file = new UserFile();
        file.setUserOpenid(openId);
        file.setFileType(fileType);
        file.setFileState("waitOrder");
        //获取要下单的文件列表
        List<UserFile> userFileList = userFileMapper.selectBySelective(file);
        file.setFileState("ordered");
        file.setFileType(null);
        file.setUserOpenid(null);
        //生成订单号

        String oid = DateUtil.getID("O") + openId.substring(0, 4);
        for (UserFile userFile : userFileList) {
            //生成订单
            Orders order = new Orders();
            order.setFileId(userFile.getFileId());
            order.setUserOpenid(openId);
            order.setOrderId(oid);
            order.setDeviceId(deviceId);
            order.setUserPoints(10);
            order.setOrderState("waitPayment");
            try {
                ordersMapper.insert(order);
            } catch (RuntimeException e) {
                log.error("创建订单失败 ,openid = " + openId + ", deviceId = " + deviceId + ", fileId = " + userFile.getFileId());
                log.error(e);
                throw new RuntimeException("Failed to generate order");
            }
            file.setFileId(userFile.getFileId());
            //更新用户文件
            userFileMapper.updateByPrimaryKeySelective(file);

        }
        return oid;

    }

    @Override
    public List<Orders> selectByPrimaryKey(String orderId) {
        return ordersMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }


}
