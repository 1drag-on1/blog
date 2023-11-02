package com.dragon.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.blog.mapper.CommentMapper;
import com.dragon.blog.pojo.Comment;
import com.dragon.blog.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @author Dragon
 * @Date 2023/8/4 14:34
 * @Description
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
