package com.xj.cloudprint.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.xj.cloudprint.entity.ResultUtil;
import com.xj.cloudprint.entity.User;
import com.xj.cloudprint.entity.UserFile;
import com.xj.cloudprint.service.UserFileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/userFile")
public class UserFileController {

    @Autowired
    UserFileService userFileService;

    private static final Logger log = Logger.getLogger(UserFileController.class);

    /**
     * 用户根据文件状态返回文件列表
     *
     * @param state
     * @return
     */
    @PostMapping("/select")
    public ResultUtil selectUserFileState(HttpSession session,
                                          @RequestParam(value = "state") String state) {
        User u = (User) session.getAttribute("user");
        UserFile file = new UserFile();
        file.setUserOpenid(u.getOpenId());
        file.setFileState(state);
        //构建文件列表
        Map<String, Object> map = new HashMap<>();
        map.put("userFileList", userFileService.selectUserFile(file));
        return ResultUtil.success(map);
    }

    /**
     * @param session
     * @param fileId
     * @return
     */
    @PostMapping("/delete")
    public ResultUtil deleteUserFile(HttpSession session,
                                     @RequestParam(value = "fileId") String fileId) {
        User u = (User) session.getAttribute("user");
        try {
            assert u != null;
        } catch (AssertionError ignored) {
            log.error("用户未登陆");
            return ResultUtil.error("用户未登陆", null);
        }
        int res = userFileService.deleteByFileId(fileId);
        if (res == 1) {
            return ResultUtil.success(null);
        } else {
            return ResultUtil.error(null);
        }
    }

}
