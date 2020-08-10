package com.xj.cloudprint.mapper;

import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.entity.UserFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(UserFile record);

    int insertSelective(UserFile record);

    UserFile selectByPrimaryKey(String fileId);

    List<UserFile> selectBySelective(UserFile userFile);

    int updateByPrimaryKeySelective(UserFile record);

    int updateByPrimaryKey(UserFile record);
}