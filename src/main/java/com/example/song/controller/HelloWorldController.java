package com.example.song.controller;

import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseException;
import com.example.song.entity.HomeEntity;
import com.example.song.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {
    @Resource
    private HomeEntity homeEntity;

    @Resource
    private UserEntity userEntity;

    @RequestMapping(value = "/")
    public Object sayHello() throws BaseException {
//        return homeEntity.toString() + userEntity.toString();
        throw new BaseException(BaseErrorInterfaceInfo.EXCEPTION);
    }
}
