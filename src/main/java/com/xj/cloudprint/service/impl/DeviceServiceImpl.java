package com.xj.cloudprint.service.impl;

import com.xj.cloudprint.entity.Device;
import com.xj.cloudprint.mapper.DeviceMapper;
import com.xj.cloudprint.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/2/9 21:44
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public int deviceConnection(Device device) {

        Device deviceOld = deviceMapper.selectByPrimaryKey(device.getDeviceId());
        if (deviceOld != null) {
            deviceMapper.updateByPrimaryKeySelective(device);
            return 1;
        } else {
            return deviceMapper.insert(device);
        }
    }

    @Override
    public List<Device> selectAll() {
        return  deviceMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(String deviceId) {
        return deviceMapper.deleteByPrimaryKey(deviceId);
    }

    @Override
    public int insert(Device record) {
        return deviceMapper.insert(record);
    }

    @Override
    public int insertSelective(Device record) {
        return deviceMapper.insertSelective(record);
    }

    @Override
    public Device selectByPrimaryKey(String deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public int updateByPrimaryKeySelective(Device record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Device record) {
        return deviceMapper.updateByPrimaryKey(record);
    }
}
