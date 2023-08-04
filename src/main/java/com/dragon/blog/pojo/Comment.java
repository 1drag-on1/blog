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
 * @Date 2023/8/4 11:26
 * @Description
 */
@Data
public class Comment {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String nickName;
    private String email;
    private String content;
    private String avatar;
    private String ip;
    private String adminComment;
    private Boolean published;
    private Integer page;
    private Boolean notice;
    private Integer articleId;
    private Integer parentCommentId;
    private String website;
    private String qq;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableLogic
    private Integer deleted;

}
