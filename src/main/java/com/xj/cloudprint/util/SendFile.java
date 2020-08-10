package com.xj.cloudprint.util;

import com.xj.cloudprint.entity.SocketFile;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/3/26 14:38
 */
public class SendFile {


    private static Logger logger = Logger.getLogger(SendFile.class);
    /**
     *  发送文件服务
     * @param socketFile 要发送的文件
     * @param port 设备对应的端口
     * @param host 服务器地址
     */
    public static void  sendFile(SocketFile socketFile, String host, int port){
        Socket socket = null;
        ObjectOutputStream os = null;
        try {
            socket = new Socket(host, port);
            os = new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(socketFile);
            os.flush();
        } catch (IOException e) {
            logger.error("传输异常:未连接服务器");
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                socket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
