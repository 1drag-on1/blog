package com.dragon.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.blog.common.shiro.JwtUtil;
import com.dragon.blog.mapper.SysUserMapper;
import com.dragon.blog.pojo.SysUser;
import com.dragon.blog.service.SysUserService;
import com.dragon.blog.util.PasswordUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Dragon
 * @Date 2023/6/7 17:27
 * @Description
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserMapper userMapper;

    public SysUserServiceImpl(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Boolean register(SysUser user) {
        try {
            SysUser sysUser = userMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, user.getUsername()));
            if (sysUser != null){
                throw new RuntimeException("该用户名已存在");
            }
            user.setCreateTime(new Date());//设置创建时间
            user.setCreateBy("admin");
            String salt = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 7)));//八位随机数
            user.setSalt(salt);
            user.setPassword(PasswordUtil.encrypt(user.getUsername(), user.getPassword(), salt));
            user.setDeleted(0);
            userMapper.insert(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public void authentication(String token) {
        String username;
        try {
            username = JwtUtil.getUsername(token);
        } catch (Exception e) {
            throw new AuthenticationException("token为空或者错误");
        }
        if ("".equals(username) || username == null) {
            throw new AuthenticationException("token无效");
        }

        SysUser sysUser = userMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        if (!JwtUtil.verify(token, username, sysUser.getPassword())) {
            throw new AuthenticationException("用户名或密码错误");
        }
    }
}
