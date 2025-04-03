package org.shaco.yizheng_crm_back.sys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.shaco.yizheng_crm_back.common.annotation.SystemLog;
import org.shaco.yizheng_crm_back.sys.entity.SysRole;
import org.shaco.yizheng_crm_back.sys.model.SysRoleQueryDTO;
import org.shaco.yizheng_crm_back.common.util.PageUtils;
import org.shaco.yizheng_crm_back.sys.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author shaco
 * @since 2025-03-28
 */
@Api(tags = "系统角色", value = "SysRole")
@CrossOrigin
//@CrossOrigin(originPatterns = "*",allowCredentials = "true")
@Controller
@RequestMapping("/sys/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleService;

    @ApiOperation(value = "查询分页角色", notes = "角色信息")
    @GetMapping("/list")
    public PageUtils list(@ApiParam(value = "chaxuntiaojian") SysRoleQueryDTO sysRoleQueryDTO) {
        return sysRoleService.queryPage(sysRoleQueryDTO);
    }

    @SystemLog("tianjiajs")
    @PostMapping("/addUser")
    public String addUser(@RequestBody SysRole sysRole) {
        sysRoleService.save(sysRole);
        return "redirect:/sys/sysRole";
    }

    @SystemLog("gengxinjs")
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody SysRole sysRole) {
        sysRoleService.update(sysRole);
        return "redirect:/sys/sysRole";
    }

    @GetMapping("/deleteRole")
    public String deleteRole(@RequestParam("roleId") Long roleId) {
        sysRoleService.removeById(roleId);
        return "redirect:/sys/sysRole";
    }

    @SystemLog("shanchujs")
    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam("roleId") Long roleId) {
        sysRoleService.removeById(roleId);
        return "redirect:/sys/sysRole";
    }
//    @DeleteMapping("/deleteUser")
//    public boolean deleteRoleById(@Param("roleId") Long roleId) {
//        Long[] roleIds = {roleId};
//        sysRoleService.deleteBatch(roleIds);
//        return true;
//    }
}
