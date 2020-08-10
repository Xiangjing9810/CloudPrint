package com.xj.cloudprint.service;

import com.xj.cloudprint.entity.SocketFile;

public interface SocketFileService {
    int deleteByPrimaryKey(String socketFileid);

    int insert(SocketFile record);

    int insertSelective(SocketFile record);

    SocketFile selectByPrimaryKey(String socketFileid);

    int updateByPrimaryKeySelective(SocketFile record);

    int updateByPrimaryKey(SocketFile record);
}
