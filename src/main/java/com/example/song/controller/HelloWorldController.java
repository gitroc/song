package com.example.song.controller;

import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseException;
import com.example.song.entity.HomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    ApplicationContext context;

    @RequestMapping(value = "/")
    public Object sayHello() throws BaseException {
        throw new BaseException(BaseErrorInterfaceInfo.SEVICE_EXCEPTION);
    }

    @RequestMapping(value = "/message")
    public void message() throws BaseException {
        StringRedisTemplate template = context.getBean(StringRedisTemplate.class);

        HomeEntity homeEntity = new HomeEntity();
        homeEntity.setProvince("江南省");
        homeEntity.setCity("南直隶");
        homeEntity.setDesc("南直隶总督胡宗宪大人是我同乡");

        template.convertAndSend("chat", homeEntity.toString());
    }
}
