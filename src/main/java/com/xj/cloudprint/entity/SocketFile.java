package com.xj.cloudprint.entity;

import java.io.Serializable;

public class SocketFile implements Serializable {
    private String socketFileid;

    private String fileName;

    private Integer fileCopies;

    private String fileRanges;

    private String fileState;

    private String ftpFilepath;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    private String openId;

    public String getSocketFileid() {
        return socketFileid;
    }

    public void setSocketFileid(String socketFileid) {
        this.socketFileid = socketFileid == null ? null : socketFileid.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Integer getFileCopies() {
        return fileCopies;
    }

    public void setFileCopies(Integer fileCopies) {
        this.fileCopies = fileCopies;
    }

    public String getFileRanges() {
        return fileRanges;
    }

    public void setFileRanges(String fileRanges) {
        this.fileRanges = fileRanges == null ? null : fileRanges.trim();
    }

    public String getFileState() {
        return fileState;
    }

    public void setFileState(String fileState) {
        this.fileState = fileState == null ? null : fileState.trim();
    }

    public String getFtpFilepath() {
        return ftpFilepath;
    }

    public void setFtpFilepath(String ftpFilepath) {
        this.ftpFilepath = ftpFilepath == null ? null : ftpFilepath.trim();
    }
}