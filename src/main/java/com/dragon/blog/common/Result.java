package com.dragon.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dragon
 * @Date 2023/6/7 17:31
 * @Description 返回类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理信息
     */
    private String message = "操作成功";

    /**
     * 返回状态代码
     */
    private Integer code = 200;

    /**
     * 返回的数据data
     */
    private T data;

    /**
     * 返回数据总条数
     */
    private long totalRow;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public void success(String message) {
        this.success = true;
        this.message = message;
        this.code = 200;
    }

    public Result<T> success(Integer code, T entity, String message) {
        Result<T> r = new Result<T>();
        r.success = true;
        r.code = code;
        r.message = message;
        r.data = entity;
        return r;
    }

    public Result<T> ok() {
        Result<T> r = new Result<>();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("操作成功");
        return r;
    }
    public Result<T> ok(T entity) {
        Result<T> r = new Result<T>();
        r.message = "操作成功";
        r.code = 200;
        r.success = true;
        r.data = entity;
        return r;
    }

    public void error() {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMessage("操作失败");
        r.setSuccess(false);
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public static Result<Object> error(String msg) {
        return error(500, msg);
    }

    public Result<T> error500(String message) {
        this.message = message;
        this.code = 500;
        this.success = false;
        return this;
    }
}
