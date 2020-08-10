package com.xj.cloudprint.mapper;

import com.xj.cloudprint.entity.Device;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/1 22:13
 */

@SpringBootTest
@RunWith(SpringRunner.class)
class DeviceMapperTest {
    @Autowired
    DeviceMapper deviceMapper;
    @Test
    void select() {
        for (Device d:deviceMapper.selectAll()) {
            System.out.println(d.toString());
        }

    }
}