package com.test.service;

import com.test.entity.SysRole;

/**
 * 表服务层
 */
public interface SysRoleService {
    SysRole selectRoleByUserId(String userId);

}
