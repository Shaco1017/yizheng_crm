package org.shaco.yizheng_crm_back.sys.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.shaco.yizheng_crm_back.common.PageDTO;

@Data
public class SysRoleQueryDTO extends PageDTO {
    @ApiModelProperty("juesemingcheng")
    private String roleName;
}
