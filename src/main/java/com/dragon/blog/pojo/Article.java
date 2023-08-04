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
 * @Date 2023/8/4 11:15
 * @Description
 */
@Data
public class Article {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String context;
    private String likes;
    private Boolean state;
    private Boolean recommend;
    private Boolean appreciation;
    private Boolean commentEnabled;
    private Boolean top;
    private Integer views;
    private Integer words;
    private Integer readTime;
    private String password;
    private String userId;
    private String category;
    private String description;
    private String firstPicture;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer createBy;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    @TableLogic
    private String deleted;

}
