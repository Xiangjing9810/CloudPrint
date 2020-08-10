package com.xj.cloudprint.service.impl;

import com.xj.cloudprint.entity.UserFile;
import com.xj.cloudprint.mapper.UserFileMapper;
import com.xj.cloudprint.service.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    UserFileMapper userFileMapper;

    @Value("${cloudPrint.coverPath}")
    private String coverPath;


    @Override
    public List<UserFile> selectUserFile(UserFile userFile) {
        List<UserFile> userFileList = userFileMapper.selectBySelective(userFile);
        for (UserFile u:userFileList) {
            u.setFileName(coverPath+u.getFileName());
        }
        return userFileList;
    }

    @Override
    public int insert(UserFile userFile) {
        return userFileMapper.insert(userFile);
    }

    @Override
    public int deleteByFileId(String fileId) {
        return userFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(UserFile record) {
        try {
             return userFileMapper.updateByPrimaryKeySelective(record);
        }catch (Exception e){
            throw new RuntimeException("Failed to update UserFile");
        }
    }
}
