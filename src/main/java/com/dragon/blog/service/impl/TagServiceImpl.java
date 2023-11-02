package com.dragon.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.blog.mapper.TagMapper;
import com.dragon.blog.pojo.Tag;
import com.dragon.blog.service.TagService;
import org.springframework.stereotype.Service;

/**
 * @author Dragon
 * @Date 2023/8/4 14:29
 * @Description
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
}
