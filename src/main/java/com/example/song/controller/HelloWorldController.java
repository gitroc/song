package com.example.song.controller;

import com.example.song.base.BaseErrorInterfaceInfo;
import com.example.song.base.BaseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping(value = "/")
    public Object sayHello() throws BaseException {
        throw new BaseException(BaseErrorInterfaceInfo.SEVICE_EXCEPTION);
    }
}
