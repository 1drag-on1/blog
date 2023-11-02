package com.dragon.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Dragon
 * @Date 2023/8/4 11:23
 * @Description
 */
@Data
public class About {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String nameEn;
    private String nameCh;
    private String value;
    @TableLogic
    private Integer deleted;

}
