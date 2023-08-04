package com.dragon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Dragon
 * @Date 2023/8/4 14:27
 * @Description
 */
@Data
public class Tag {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String tagName;
    private String color;
    @TableLogic
    private Integer deleted;

}
