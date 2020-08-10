package com.xj.cloudprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Device {
    private String deviceId;

    private String deviceName;
    @JsonIgnore
    private Integer devicePort;
    @JsonIgnore
    private String deviceState;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(Integer devicePort) {
        this.devicePort = devicePort;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState == null ? null : deviceState.trim();
    }

    public Device(String deviceId, String deviceName, Integer devicePort, String deviceState) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.devicePort = devicePort;
        this.deviceState = deviceState;
    }
}