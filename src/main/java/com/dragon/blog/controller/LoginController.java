package com.dragon.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dragon.blog.common.Result;
import com.dragon.blog.common.shiro.JwtToken;
import com.dragon.blog.common.shiro.JwtUtil;
import com.dragon.blog.pojo.SysUser;
import com.dragon.blog.service.SysUserService;
import com.dragon.blog.util.PasswordUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author Dragon
 * @Date 2023/6/13 15:15
 * @Description
 */
@RestController
@Slf4j
@Api(tags = "登录接口")
public class LoginController {

    private final SysUserService sysUserService;

    public LoginController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
    @PostMapping("/login")
    public Result<HashMap<String, Object>> login(@RequestBody SysUser sysUser, HttpServletResponse response){
        Result<HashMap<String, Object>> result = new Result<>();

        SysUser user = sysUserService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, sysUser.getUsername()));
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        String token = JwtUtil.sign(sysUser.getUsername(), PasswordUtil.encrypt(sysUser.getUsername(), sysUser.getPassword(), user.getSalt()));
        JwtToken jwtToken = new JwtToken(token);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(jwtToken);
            (response).setHeader("Token", token);
        } catch (Exception e) {
            log.error("认证失败");
            throw new ShiroException("用户名或密码错误");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("token", jwtToken.getPrincipal());
        result.setData(map);
        result.success("登录成功");
        return result;
    }

}
