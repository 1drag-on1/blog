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

    private String headName;

    private String email;

    private String wechat;

    private String qq;

    private String introduction;

    private Integer deleted;

    private Date createTime;

    private Date updateTime;

}
