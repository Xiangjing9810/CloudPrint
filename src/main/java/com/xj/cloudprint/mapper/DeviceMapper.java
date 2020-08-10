package com.xj.cloudprint.mapper;

import com.xj.cloudprint.entity.Device;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);


    List<Device> selectAll();
    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}