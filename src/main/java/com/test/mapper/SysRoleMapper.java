package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * SysRoleDAO继承基类
 * @author root
 */
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    SysRole selectRoleByUserId(String userId);
}