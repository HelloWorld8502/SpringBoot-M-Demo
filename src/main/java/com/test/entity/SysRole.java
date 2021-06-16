package com.test.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class SysRole implements Serializable {
    /**
     * 序号
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 角色权限标识
     */
    private String rolekey;

    private static final long serialVersionUID = 1L;
}