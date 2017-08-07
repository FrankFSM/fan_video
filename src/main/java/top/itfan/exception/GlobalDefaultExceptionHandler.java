package top.itfan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalDefaultExceptionHandler
 * 全局异常处理
 *
 * @Author: ralap
 * @Date: created at 2017/8/7 13:50
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * 拦截所有异常
     */
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest request, ExceptionHandler e) {
    }
}
