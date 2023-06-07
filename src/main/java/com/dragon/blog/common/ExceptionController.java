package com.dragon.blog.common;

import com.dragon.blog.util.ExceptionUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dragon
 * @Date 2023/6/7 18:06
 * @Description
 */
@Slf4j
@RestControllerAdvice
public class ExceptionController {

    /**
     * 运行时异常
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<Object> runtimeException(Exception e, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        log.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        log.error(ExceptionUtil.getMessage(e));
        return Result.error(500, e.getMessage());
    }


    @ExceptionHandler(NullPointerException.class)
    public Result<Object> nullPointerException(NullPointerException e, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        log.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        log.error(ExceptionUtil.getMessage(e));
        return Result.error(500, "空指针");
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result<Object> indexOutOfBoundsException(IndexOutOfBoundsException  e, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        log.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        log.error(ExceptionUtil.getMessage(e));
        return Result.error(500, "数组越界");
    }

    /**
     * 捕获shiro的异常
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(ShiroException.class)
    public Result<Object> handle401(ShiroException e, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        log.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        log.error(ExceptionUtil.getMessage(e));
        return Result.error(401, e.getMessage());
    }

    /**
     * 捕获未认证的异常
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result handle402(AuthenticationException e, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        log.error(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        log.error(ExceptionUtil.getMessage(e));
        return Result.error(402, e.getMessage());
    }
}
