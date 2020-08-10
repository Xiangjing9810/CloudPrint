package com.xj.cloudprint.service.impl;

import com.xj.cloudprint.entity.SocketFile;
import com.xj.cloudprint.mapper.SocketFileMapper;
import com.xj.cloudprint.service.SocketFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/1 23:35
 */
@Service
public class SocketFileServiceImpl implements SocketFileService {

    @Autowired
    SocketFileMapper socketFileMapper;
    @Override
    public int deleteByPrimaryKey(String socketFileid) {
        return socketFileMapper.deleteByPrimaryKey(socketFileid);
    }

    @Override
    public int insert(SocketFile record) {
        return socketFileMapper.insert(record);
    }

    @Override
    public int insertSelective(SocketFile record) {
        return insertSelective(record);
    }

    @Override
    public SocketFile selectByPrimaryKey(String socketFileid) {
        return socketFileMapper.selectByPrimaryKey(socketFileid);
    }

    @Override
    public int updateByPrimaryKeySelective(SocketFile record) {
        return socketFileMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SocketFile record) {
        return socketFileMapper.updateByPrimaryKey(record);
    }
}
