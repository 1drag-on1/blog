package com.dragon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Dragon
 * @Date 2023/4/4 10:17
 */
@Data
public class SysUser {

    @TableId(type = IdType.AUTO)
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

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateBy;
    @TableLogic
    private Integer deleted;

}
