package com.example.song.controller;

import com.example.song.domain.HomeProperties;
import com.example.song.domain.UserProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {
    @Resource
    private HomeProperties homeProperties;

    @Resource
    private UserProperties userProperties;

    @RequestMapping(value = "/")
    public String sayHello() {
        return homeProperties.toString() + userProperties.toString();
    }
}
