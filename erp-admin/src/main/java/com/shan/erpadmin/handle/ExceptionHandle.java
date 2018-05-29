package com.shan.erpadmin.handle;

import com.shan.erpadmin.domain.Result;
import com.shan.erpadmin.exception.NewsListException;
import com.shan.erpadmin.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof NewsListException) {
            NewsListException newsListException = (NewsListException) e;
            return ResultUtils.error(newsListException.getCode(), e.getMessage());
        } else {
            return ResultUtils.error(-1, e.getMessage());
        }
    }
}
