package com.dragon.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.blog.mapper.MomentMapper;
import com.dragon.blog.pojo.Moment;
import com.dragon.blog.service.MomentService;
import org.springframework.stereotype.Service;

/**
 * @author Dragon
 * @Date 2023/8/4 14:36
 * @Description
 */
@Service
public class MomentServiceImpl extends ServiceImpl<MomentMapper, Moment> implements MomentService {
}
