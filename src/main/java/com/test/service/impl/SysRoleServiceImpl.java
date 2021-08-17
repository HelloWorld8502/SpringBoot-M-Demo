package com.test.service.impl;

import com.test.aop.TimeTest;
import com.test.entity.SysRole;
import com.test.mapper.SysRoleMapper;
import com.test.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * @description:
 * @author: root
 * @date: 2021/6/16 23:49
 * @version: v1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    @Lazy
    private SysRoleMapper sysRoleMapper;

    @Override
    @TimeTest
    public SysRole selectRoleByUserId(String userId) {
        return this.sysRoleMapper.selectRoleByUserId(userId);
    }
}
