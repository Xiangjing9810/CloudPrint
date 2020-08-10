package com.xj.cloudprint.controller;

import com.xj.cloudprint.entity.Device;
import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/2/9 21:55
 */
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    private static final Logger log = Logger.getLogger(DeviceController.class);
    /**
     * 设备连接
     *
     * @param deviceId
     * @param deviceName
     * @param devicePort
     * @param deviceState
     * @return
     */
    @PostMapping(value = "/connection")
    public ResultUtil deviceConnection(@RequestParam(value = "deviceId") String deviceId,
                                       @RequestParam(value = "deviceName") String deviceName,
                                       @RequestParam(value = "devicePort") int devicePort,
                                       @RequestParam(value = "deviceState") String deviceState) {
        Device device = new Device(deviceId, deviceName, devicePort, deviceState);
        return deviceService.deviceConnection(device) == 1 ? ResultUtil.success(null) : ResultUtil.error(null);

    }

    /**
     * 获取设备列表
     *
     * @return
     */
    @GetMapping(value = "/select")
    public ResultUtil selectDevice() {
        return ResultUtil.success(deviceService.selectAll());
    }


}
