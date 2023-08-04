package com.dragon.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.blog.mapper.ArticleMapper;
import com.dragon.blog.pojo.Article;
import com.dragon.blog.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author Dragon
 * @Date 2023/8/4 14:33
 * @Description
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
