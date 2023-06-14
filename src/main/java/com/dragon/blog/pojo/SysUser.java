package com.dragon.blog.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Dragon
 * @Date 2023/4/4 10:17
 */
@Data
public class SysUser {

    private Integer id;

    private String name;

    private String username;

    private String password;

    private String salt;

    private String role;

    private String headName;

    private String email;

    private String wechat;

    private String qq;

    private String introduction;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Integer deleted;

}
