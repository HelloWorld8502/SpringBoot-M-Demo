package com.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @description:  代理 aop编程 计算方法耗时
 * @author: root
 * @date: 2021/6/17 0:11
 * @version: v1.0
 */
@Aspect
@Slf4j
public class TimeTestAspect {

    /*
     * 切入表达式
     */
    @Pointcut(value = "@annotation(TimeTest)")
    public void timeTest()
    {

    }

    @Around(value = "timeTest() && @annotation(time)")
    public Object around(ProceedingJoinPoint pjp,TimeTest time) throws Throwable {
        long date = System.currentTimeMillis();
        Object o = pjp.proceed();
        log.info("方法执行时间:"+(System.currentTimeMillis()-date));
        return o;
    }

}
