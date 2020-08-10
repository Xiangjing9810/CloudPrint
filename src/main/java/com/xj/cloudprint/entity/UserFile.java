package com.xj.cloudprint.entity;

public class UserFile {
    private String fileId;

    private String userOpenid;

    private String fileName;

    private String isShared;

    private String filePath;

    private String fileType;

    private String fileState;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid == null ? null : userOpenid.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getIsShared() {
        return isShared;
    }

    public void setIsShared(String isShared) {
        this.isShared = isShared == null ? null : isShared.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileState() {
        return fileState;
    }

    public void setFileState(String fileState) {
        this.fileState = fileState == null ? null : fileState.trim();
    }

    @Override
    public String toString() {
        return "UserFile{" +
                "fileId='" + fileId + '\'' +
                ", userOpenid='" + userOpenid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", isShared='" + isShared + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileState='" + fileState + '\'' +
                '}';
    }
}