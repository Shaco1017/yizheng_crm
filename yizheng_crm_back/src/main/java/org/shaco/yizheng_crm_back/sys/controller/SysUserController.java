package org.shaco.yizheng_crm_back.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.shaco.yizheng_crm_back.sys.entity.SysUser;
import org.shaco.yizheng_crm_back.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author shaco
 * @since 2025-03-28
 */
@Api(tags = "系统用户",value = "SysUser")
@CrossOrigin
@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    @ApiOperation(value = "查询系统用户",notes = "查询用户")
    @GetMapping("/list")
    public List<SysUser> list(){
        return sysUserService.list();
    }
}
