package org.shaco.yizheng_crm_back.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.shaco.yizheng_crm_back.common.util.PageUtils;
import org.shaco.yizheng_crm_back.sys.entity.SysRole;
import org.shaco.yizheng_crm_back.sys.mapper.SysRoleMapper;
import org.shaco.yizheng_crm_back.sys.model.SysRoleQueryDTO;
import org.shaco.yizheng_crm_back.sys.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author shaco
 * @since 2025-03-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    // TODO 分页查询
    @Override
    public PageUtils queryPage(SysRoleQueryDTO queryDTO) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>().like(
                StringUtils.isNotBlank(queryDTO.getRoleName()), "role_name", queryDTO.getRoleName()
        );
        Page<SysRole> page = this.page(queryDTO.page(), queryWrapper);

        return new PageUtils(page);
    }

    @Override
    public void saveRole(SysRole role) {
        // 判断 角色编号是否存在，如果存在就走更新的逻辑否则新增数据
        if (role.getRoleId() != null && role.getRoleId() != 0) {
        // 表示更新操作
            this.update(role);
        } else {
            role.setCreateTime(LocalDateTime.now());
            this.save(role);
        }
    }

    @Override
    public void update(SysRole role) {

    }

    @Override
    public void deleteBatch(Long[] roleIds) {

    }

    @Override
    public boolean deleteRoleById(Long roleId) {
        return true;
    }
}
