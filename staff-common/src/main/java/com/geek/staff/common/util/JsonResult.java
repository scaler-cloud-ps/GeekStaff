package com.geek.staff.common.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JsonResult<T> {

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 发生异常
     */
    public static final int EXCEPTION = 401;
    /**
     * 业务异常
     */
    public static final int SYS_ERROR = 402;
    /**
     * 参数错误
     */
    public static final int PARAMS_ERROR = 403;
    /**
     * 数据异常
     */
    public static final int DATA_ERROR = 405;
    /**
     * 不支持或者已废弃
     */
    public static final int NO_SUPPORTED = 410;
    /**
     * 太频繁的调用
     */
    public static final int TOO_FREQUENT = 445;
    /**
     * 未知错误
     */
    public static final int UNKNOW_ERROR = 499;

    private boolean success;
    private String msg;
    private int code;
    private T data;

    public JsonResult<T> success(boolean success) {
        this.success = success;
        return this;
    }

    public JsonResult<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public JsonResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public JsonResult<T> data(T data) {
        this.data = data;
        return this;
    }

    private static <T> JsonResult<T> build(boolean success, String msg, int code, T data) {
        return new JsonResult<T>().success(success).msg(msg).code(code).data(data);
    }

    public static JsonResult ok() {
        return build(true, null, SUCCESS, null);
    }
    public static JsonResult ok(String msg) {
        return build(true, msg, SUCCESS, null);
    }
    public static <T> JsonResult<T> ok(T data) {
        return build(true, null, SUCCESS, data);
    }
    public static <T> JsonResult<T> ok(String msg, T data) {
        return build(true, msg, SUCCESS, data);
    }

    public static JsonResult error() {
        return build(false, null, EXCEPTION, null);
    }

    public static JsonResult error(String msg) {
        return build(false, msg, EXCEPTION, null);
    }

    public JsonResult(Throwable e, int code) {
        this.success = false;
        this.msg = e.getMessage();
        this.code = code;
    }
}
