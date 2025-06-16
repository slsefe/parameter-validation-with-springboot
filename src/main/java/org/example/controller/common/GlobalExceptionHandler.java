package org.example.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * 异常统计拦截处理
 * 这样，在出现参数校验异常，比如空指针时，不会把服务的内部错误信息直接输出给用户
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(code = BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleParameterVerificationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return Result.fail(bindingResult.getFieldError().getDefaultMessage());
    }

}
