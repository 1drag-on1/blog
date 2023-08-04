package com.dragon.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.blog.mapper.VisitorMapper;
import com.dragon.blog.pojo.Visitor;
import com.dragon.blog.service.VisitorService;
import org.springframework.stereotype.Service;

/**
 * @author Dragon
 * @Date 2023/8/4 14:39
 * @Description
 */
@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements VisitorService {
}
