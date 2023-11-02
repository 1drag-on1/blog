package com.dragon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Dragon
 * @Date 2023/8/4 14:22
 * @Description
 */
@Data
public class Moment {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String content;
    private Integer likes;
    private Boolean published;
    @TableLogic
    private Integer deleted;

}
