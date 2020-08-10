package com.xj.cloudprint.util;

import com.xj.cloudprint.config.common;
import com.xj.cloudprint.entity.SocketFile;

import java.io.File;

/**
 * @author xiangjing
 * @version 1.0
 * @date 2020/2/10 16:48
 */
public class SendFileTest implements Runnable{
    @Override
    public void run() {
        SocketFile file = new SocketFile();
        file.setSocketFileid("omB9H42CuKL4hChEp46r3I_sgcFQ");
        file.setOpenId("omB9H42CuKL4hChEp46r3I_sgcFQ");
        file.setFileName("wxae8b8e6960d875a3.o6zAJs3dCn7XVUd0912foPzuox3I.AaOsHWoQ1yUha28da83b3e67bd7fdfa0146bb7c7638a.jpg");
        file.setFileCopies(1);
        SendFile.sendFile(file, common.remoteAddress,10246);
    }
    public static void main(String[] args) {
        new Thread(new SendFileTest()).start();
    }
}
