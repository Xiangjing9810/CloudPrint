package com.xj.cloudprint.mapper;

import com.xj.cloudprint.entity.SocketFile;

public interface SocketFileMapper {
    int deleteByPrimaryKey(String socketFileid);

    int insert(SocketFile record);

    int insertSelective(SocketFile record);

    SocketFile selectByPrimaryKey(String socketFileid);

    int updateByPrimaryKeySelective(SocketFile record);

    int updateByPrimaryKey(SocketFile record);
}