package com.dragon.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragon.blog.common.Result;
import com.dragon.blog.common.shiro.JwtUtil;
import com.dragon.blog.pojo.SysUser;
import com.dragon.blog.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author Dragon
 * @Date 2023/4/4 10:16
 */

@RestController
@RequestMapping("/sys")
public class SysUserController {

    private final SysUserService sysUserService;

    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result<SysUser> register(@RequestBody SysUser user) {
        Result<SysUser> result = new Result<>();
        Boolean b = sysUserService.register(user);
        if (!b) {
            throw new RuntimeException("注册失败");
        }
        result.success("添加成功！");
        return result;
    }

    /**
     * 按名字和用户类型搜索
     *
     * @param name
     * @param role
     * @return
     */
    @GetMapping("/getList")
    public Result<List<SysUser>> getList(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "role", required = false) String role,
                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         @RequestParam(value = "startTime", required = false) Date startTime,
                                         @RequestParam(value = "endTime", required = false) Date endTime) {
        Result<List<SysUser>> result = new Result<>();
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(SysUser::getCreateTime);//倒序
        if (startTime != null && endTime != null) {
            wrapper.ge(SysUser::getCreateTime, startTime).le(SysUser::getCreateTime, endTime);
        }

        Page<SysUser> page = new Page<>(pageNum, pageSize);
        //两个变量都非必选，这里判断哪个不为null做相对应匹配
        if (!"".equals(name) && !"".equals(role)) {
            wrapper.eq(SysUser::getName, name).eq(SysUser::getRole, role);
            sysUserService.page(page, wrapper);
        } else if ("".equals(name) && !"".equals(role)) {
            wrapper.eq(SysUser::getRole, role);
            sysUserService.page(page, wrapper);
        } else if (!"".equals(name)) {
            wrapper.eq(SysUser::getName, name);
            sysUserService.page(page, wrapper);
        } else {
            sysUserService.page(page);
        }
        result.setData(page.getRecords());
        result.setTotalRow(page.getTotal());
        return result;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("/editUser")
    public Result<SysUser> editUser(@RequestBody SysUser user) {
        Result<SysUser> result = new Result<>();
        boolean b = sysUserService.updateById(user);
        if (!b) {
            return result.error500("修改失败");
        }
        return result.ok();
    }

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    @GetMapping("/deletedUser")
    public Result<SysUser> deletedUser(@RequestParam List<String> ids) {
        Result<SysUser> result = new Result<>();
        boolean b = sysUserService.removeByIds(ids);
        if (!b) {
            return result.error500("删除失败");
        }
        return result.ok();
    }

//    @RequestMapping(value = "/logout")
//    public Result<Object> logout(HttpServletRequest request, HttpServletResponse response) {
//        //用户退出逻辑
//        String token = request.getHeader("Token");
//        if (StringUtils.isBlank(token)) {
//            return Result.error("退出登录失败！");
//        }
//        String username = JwtUtil.getUsername(token);
//        SysUser sysUser = sysBaseAPI.getUserByName(username);
//        if (sysUser != null) {
//            sysBaseAPI.addLog("用户名: " + sysUser.getRealname() + ",退出成功！", CommonConstant.LOG_TYPE_1, null);
//            log.info(" 用户名:  " + sysUser.getRealname() + ",退出成功！ ");
//            //清空用户登录Token缓存
//            redisUtil.del(CommonConstant.PREFIX_USER_TOKEN + token);
//            //清空用户登录Shiro权限缓存
//            redisUtil.del(CommonConstant.PREFIX_USER_SHIRO_CACHE + sysUser.getId());
//            return Result.ok("退出登录成功！");
//        } else {
//            return Result.error("Token无效!");
//        }
//    }

}
