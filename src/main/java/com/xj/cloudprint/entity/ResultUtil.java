package com.xj.cloudprint.entity;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class ResultUtil {
    /**
     * 响应业务状态
     */
    private Integer status;

    // 响应消息
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultUtil(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtil(Object data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResultUtil() {
        this.status = 500;
        this.msg = "error";
        this.data = null;
    }

    public static ResultUtil success(Object data) {
        return new ResultUtil(data);
    }

    public static ResultUtil error(Object data) {
        return new ResultUtil(2001, "error", data);
    }
    public static ResultUtil error(String meg ,Object data) {
        return new ResultUtil(2001, meg, data);
    }

    @Override
    public String toString() {
        return "ResultUtil [status=" + status + ", msg=" + msg + ", data=" + data + "]";
    }

}
