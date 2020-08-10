package com.xj.cloudprint.service;

import com.xj.cloudprint.entity.Device;

import java.util.List;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/2/9 21:44
 */
public interface DeviceService {


    /**
     * 连接设备
     *
     * @param device
     * @return 1 连接成功 0 连接失败
     */
    int deviceConnection(Device device);
    /**
     * 搜索所有上线的设备
     * @return
     */
    List<Device> selectAll();

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}
