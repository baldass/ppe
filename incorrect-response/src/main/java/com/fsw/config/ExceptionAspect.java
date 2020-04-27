package com.fsw.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.PessimisticLockingFailureException;

/**
 * 由AOP实现的同意异常处理
 */
@Aspect
@Configuration
public class ExceptionAspect {
    @Pointcut("execution(* com.fsw.controller.*.*(..))")
    public void cut() {
    }

    @Before("cut()")
    public void before(JoinPoint joinPoint) throws JsonProcessingException {
        //获取请求的方法
        Signature sig = joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();
        System.out.print("请求方法[" + method);
        //获取请求的参数
        Object[] args = joinPoint.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("];请求参数:" + mapper.writeValueAsString(args));
    }

    @Around("cut()")
    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (ApiResponse ae) {
            System.out.println("自定义异常!");
            return ae.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
