package com.dragon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Dragon
 * @Date 2023/8/4 14:24
 * @Description
 */
@Data
public class Visitor {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableId(type = IdType.ASSIGN_UUID)
    private String uuid;
    private String ip;
    private String ipSource;
    private String os;
    private String browser;
    private Integer pv;
    private String userAgent;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
