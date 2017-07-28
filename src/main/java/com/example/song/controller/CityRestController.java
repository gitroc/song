package com.example.song.controller;

import com.example.song.constant.ResultCode;
import com.example.song.domain.City;
import com.example.song.domain.JsonResult;
import com.example.song.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public Object findOneCity(@PathVariable("id") int id) {
        return new JsonResult(ResultCode.SUCCESS, "返回成功",  cityService.findCityById(id));
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public Object findAllCity() {
        return new JsonResult(ResultCode.SUCCESS, "返回成功", cityService.findAllCity());
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody City city) {
        cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
        cityService.updateCity(city);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") int id) {
        cityService.deleteCity(id);
    }
}
