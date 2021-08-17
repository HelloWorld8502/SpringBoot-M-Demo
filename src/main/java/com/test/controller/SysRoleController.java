package com.test.controller;

import com.test.entity.SysRole;
import com.test.service.SysRoleService;
import com.test.task.WebSocketSendDateTask;
import com.test.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: root
 * @date: 2021/6/16 23:53
 * @version: v1.0
 */
@RequestMapping("test")
@ResponseBody
@RestController

public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private WebSocketSendDateTask webSocketSendDateTask;

    @GetMapping("selectRoleByUserId/{userId}")
    public ResultMsg<SysRole> selectByUserId(@PathVariable(value = "userId") String userId)
    {
        return ResultMsg.success(this.sysRoleService.selectRoleByUserId(userId));
    }

}
