package com.example.song.aop;

import com.alibaba.fastjson.JSON;
import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseRspEntity;
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
            result = new BaseRspEntity(BaseErrorInterfaceInfo.NOT_LOGIN);
        }

        try {
            if (result == null) {
                // 一切正常的情况下，继续执行被拦截的方法
                result = pjp.proceed();
            }
        } catch (Throwable e) {
            logger.info("exception: ", e);
            result = new BaseRspEntity(e);
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

        if ("POST".equals(request.getMethod())) {
            logger.info("请求参数 : " + JSON.toJSONString(joinPoint.getArgs()));
        } else {
            logger.info("请求参数 : " + request.getQueryString());
        }

    }

    @AfterReturning(returning = "ret", pointcut = "song()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        BaseRspEntity result = (BaseRspEntity) ret;

        if (null != result) {
            logger.info("返回码    :" + result.getCode());
            logger.info("返回消息  :" + result.getMessage());
            if (null != result.getResult()) {
                logger.info("返回内容 : " + ret);
            }
        }

        logger.info("消耗时间 : " + (System.currentTimeMillis() - startTime.get()) + "毫秒");
    }

    private boolean needVerify(HttpServletRequest request) {
        if ("-1".equals(request.getHeader("authentication"))) {
            return false;
        }

        return false;
    }
}
