package com.geek.staff.common.exception;

/**
 * 参数异常类
 */
public class ParamException extends RuntimeException {

    public ParamException() {
        super();
    }

    public ParamException(String msg) {
        super(msg);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    public ParamException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
