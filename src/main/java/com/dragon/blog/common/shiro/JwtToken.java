package com.dragon.blog.common.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Dragon
 * @Date 2023/6/7 17:56
 * @Description
 */
public class JwtToken extends UsernamePasswordToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
