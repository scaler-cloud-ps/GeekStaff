package com.geek.staff.common.handler;

import com.geek.staff.common.exception.BusinessException;
import com.geek.staff.common.exception.ParamException;
import com.geek.staff.common.exception.ServiceException;
import com.geek.staff.common.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @ControllerAdvice 注解描述的类为异常处理类， 此类中可以定义多个异常处理方法
 */

@RestControllerAdvice  // ==@ControllerAdvice 和 @ResponseBody
public class GlobaleExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandlerRuntimeException(RuntimeException e) {
        JsonResult jsonResult = null;
        if (e instanceof ParamException) {
            // 运行时接口传参异常
            new JsonResult<>(e, JsonResult.PARAMS_ERROR);
        }else if (e instanceof BusinessException) {
            // 用户数据异常
            new JsonResult<>(e, JsonResult.DATA_ERROR);
        }else if (e instanceof ServiceException) {
            // 运行时业务异常
            new JsonResult<>(e, JsonResult.SYS_ERROR);
        } else {
            // 其他的运行时异常
            new JsonResult<>(e, JsonResult.EXCEPTION);
        }
        e.printStackTrace();
        return jsonResult;
    }
}
