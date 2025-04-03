package org.shaco.yizheng_crm_back.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shaco.yizheng_crm_back.common.util.PageUtils;
import org.shaco.yizheng_crm_back.sys.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.shaco.yizheng_crm_back.sys.model.SysRoleQueryDTO;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author shaco
 * @since 2025-03-28
 */
public interface ISysRoleService extends IService<SysRole> {

    PageUtils queryPage(SysRoleQueryDTO queryDTO);

    void saveRole(SysRole role);

    void update(SysRole role);

    void deleteBatch(Long[] roleIds);

    boolean deleteRoleById(Long roleId);
}
