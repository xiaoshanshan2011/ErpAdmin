package com.shan.erpadmin.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 切点
     */
    @Pointcut("execution(public * com.shan.erpadmin.controller.NewsListController.*(..))")
    public void log() {
    }

    /**
     * 拦截请求前
     */
    @Before("log()")
    public void doBefore() {
        logger.info("11111");
    }

    /**
     * 拦截请求后
     */
    @After("log()")
    public void doAfter() {
        logger.info("222222222");
    }
}
