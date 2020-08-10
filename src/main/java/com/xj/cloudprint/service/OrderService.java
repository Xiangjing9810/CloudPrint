package com.xj.cloudprint.service;

import com.xj.cloudprint.entity.Orders;

import java.util.List;

public interface OrderService {
    int deleteByPrimaryKey(String orderId);

    String generateOrder(String openId, String fileType,String deviceId);

    int insertSelective(Orders record);

    List<Orders> selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}
