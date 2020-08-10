package com.xj.cloudprint.service;

import com.xj.cloudprint.entity.UserFile;

import java.util.List;

public interface UserFileService {
    /**
     * 根据状态查找文件
     * @param userFile
     * @return
     */
    List<UserFile> selectUserFile(UserFile userFile);
    int insert(UserFile userFile);
    int  deleteByFileId(String fileId);
    int updateByPrimaryKeySelective(UserFile record);
}
