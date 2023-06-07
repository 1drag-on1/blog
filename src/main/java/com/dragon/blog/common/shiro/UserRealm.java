package com.dragon.blog.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dragon.blog.pojo.SysUser;
import com.dragon.blog.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @author Dragon
 * @Date 2023/6/7 17:56
 * @Description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    @Lazy
    private SysUserService sysUserService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("-------------shiro授权开始--------------");
//        String account = JwtUtil.getUsername(principalCollection.toString());
//        //身份授权
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        SysUser user = sysUserService.getOne(new LambdaQueryWrapper<SysUser>().select(SysUser::getRole).eq(SysUser::getAccount, account));
//        if ("admin".equals(user.getRole())) {
//            info.addRole(user.getRole());
//        }
//        info.addRole("user");
////        SysRole role = sysRoleMapper.selectOne(new LambdaQueryWrapper<SysRole>().eq(SysRole::getUserId, user.getId()));
////        info.addStringPermission(role.getPermissions());
//        return info;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("-------------shiro认证开始--------------");
////        String token = (String) authenticationToken.getCredentials();
////        if (token == null) {
////            throw new AuthenticationException("token为空!");
////        }
//        String token = (String) authenticationToken.getPrincipal();
//        sysUserService.authentication(token);
//        return new SimpleAuthenticationInfo(token, token, getName());
        return null;
    }
}
