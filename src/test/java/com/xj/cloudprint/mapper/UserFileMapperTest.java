package com.xj.cloudprint.mapper;

import com.xj.cloudprint.entity.UserFile;
import com.xj.cloudprint.service.OrderService;
import com.xj.cloudprint.service.impl.OrderServiceImpl;
import com.xj.cloudprint.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserFileMapperTest {
    @Autowired
    OrderService orderService;

    @Test
    void insert() {
       // orderService.generateOrder("omB9H42CuKL4hChEp46r3I_sgcFQ","dC13wU#2");
    }

    @Test
    void selectBySelective() {
//        UserFile file = new UserFile();
//        file.setUserOpenid("omB9H42CuKL4hChEp46r3I_sgcFQ");
//        file.setFileState("waitOrder");
//        List<UserFile> fileList = userFileMapper.selectBySelective(file);
//        for (UserFile userFile : fileList) {
//            System.out.println(userFile.toString());
//        }

    }



}