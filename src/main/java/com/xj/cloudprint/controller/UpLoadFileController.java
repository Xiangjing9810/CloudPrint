package com.xj.cloudprint.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.entity.SocketFile;
import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.entity.UserFile;
import com.xj.cloudprint.service.SocketFileService;
import com.xj.cloudprint.service.UserFileService;
import com.xj.cloudprint.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Controller
@RequestMapping("/upload")
public class UpLoadFileController {

    @Autowired
    UserFileService userFileService;
    @Autowired
    SocketFileService socketFileService;
    private static final Logger log = Logger.getLogger(UpLoadFileController.class);

    @Value("${cloudPrint.fileUploadPath}")
    private String localPath;

    /**
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/pic")
    @ResponseBody
    public ResultUtil upLoadPic(HttpServletRequest request, HttpSession session,
                                @RequestParam("fileType") String fileType,
                                @RequestParam(value = "copies", required = false, defaultValue = "1") Integer copies)
            throws IllegalStateException, IOException {
        User u = (User) session.getAttribute("user");
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                session.getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            //本地地址+openid+文件类型
            String path = localPath + File.separatorChar + u.getOpenId() + File.separatorChar
                    + fileType;
            //检查目录是否存在
            ckeckPath(path);
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    //保存文件
                    file.transferTo(new File(path + File.separatorChar + file.getOriginalFilename()));
                    //生成文件ID
                    generateUserFile(file.getOriginalFilename(), fileType, copies, u.getOpenId(), path);
                }
            }
            return ResultUtil.success("上传成功");
        }
        return ResultUtil.success("上传失败");
    }

    @RequestMapping("/doc")
    @ResponseBody
    public ResultUtil upLoadDoc(HttpServletRequest request, HttpSession session,
                                @RequestParam("fileName") String fileName,
                                @RequestParam("fileType") String fileType,
                                @RequestParam(value = "copies", required = false, defaultValue = "1") Integer copies)
            throws IllegalStateException, IOException {
        User u = (User) session.getAttribute("user");
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                session.getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            String path = localPath + File.separatorChar + u.getOpenId() + File.separatorChar
                    + fileType;
            //检查文件路径是否存在
            ckeckPath(path);
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile(iter.next());
                //
                if (file != null) {
                    file.transferTo(new File(path + File.separatorChar + fileName));
                    generateUserFile(fileName, fileType, copies, u.getOpenId(), path);
                }
            }
            return ResultUtil.success("上传成功");
        }

        return ResultUtil.success("上传失败");
    }
    private void generateUserFile(String fileName, String fileType, Integer copies, String openid, String path) {
        SocketFile sf = new SocketFile();
        UserFile userFile = new UserFile();
        userFile.setFileId(DateUtil.getID("F") + openid.substring(0, 4));
        userFile.setFileName(fileName);
        userFile.setIsShared("Y");
        userFile.setUserOpenid(openid);
        userFile.setFilePath(path);
        userFile.setFileType(fileType);
        userFile.setFileState("waitOrder");
        userFileService.insert(userFile);
        sf.setFileName(fileName);
        sf.setSocketFileid(userFile.getFileId());
        sf.setFileState("waitSend");
        sf.setFileCopies(copies);
        sf.setFtpFilepath(File.separator+openid+File.separator+fileType);
        socketFileService.insert(sf);
        log.info("文件信息" + userFile.toString());
    }

    private void ckeckPath(String path) {
        log.info("文件保存地址：" + path);
        File myPath = new File(path);
        //如果文件夹不存在就创建
        if (!myPath.exists()) {
            myPath.mkdirs();
        }
    }
}
