package com.example.song.aop;

import com.alibaba.fastjson.JSON;
import com.example.song.constant.ResultCode;
import com.example.song.domain.JsonResult;
import com.example.song.service.TokenService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Order(5)
@Component
public class SongAspect {
    @Autowired
    private TokenService tokenService;

    private Logger logger = LoggerFactory.getLogger(SongAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.song.controller..*.*(..))")
    public void song() {
    }

    @Around("song()")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Object result = null;

        if (!needVerify(request)) {
            logger.info("登录成功");

        } else {
            if (null != tokenService.getToken(request.getHeader("token"))) {
                logger.info("登录成功");
            }
            result = new JsonResult(ResultCode.NOT_LOGIN, "登录失败");
        }

        try {
            if (result == null) {
                // 一切正常的情况下，继续执行被拦截的方法
                result = pjp.proceed();
            }
        } catch (Throwable e) {
            logger.info("exception: ", e);
            result = new JsonResult(ResultCode.EXCEPTION, "发生异常", e.getMessage());
        }

        return result;
    }

    @Before("song()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("请求方法 : " + request.getMethod());
        logger.info("IP地址 : " + request.getRemoteAddr());
        logger.info("处理接口 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数 : " + JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "song()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        JsonResult result = (JsonResult) ret;
        logger.info("返回码    :" + result.getCode());
        logger.info("返回消息  :" + result.getMessage());
        if (null != result.getResult()) {
            logger.info("返回内容 : " + ret);
        }

        logger.info("消耗时间 : " + (System.currentTimeMillis() - startTime.get()) + "毫秒");
    }

    private boolean needVerify(HttpServletRequest request) {
        if ("-1".equals(request.getHeader("authentication"))) {
            return false;
        }

        return true;
    }
}
