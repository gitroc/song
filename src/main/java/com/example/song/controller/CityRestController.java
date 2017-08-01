package com.example.song.controller;

import com.example.song.base.BaseException;
import com.example.song.entity.CityEntity;
import com.example.song.base.BaseRspEntity;
import com.example.song.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public Object findOneCity(@PathVariable("id") int id) throws BaseException {
        return new BaseRspEntity(cityService.findCityById(id));
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public Object findAllCity() throws BaseException {
        return new BaseRspEntity(cityService.findAllCity());
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public void createCity(@RequestBody CityEntity cityEntity) throws BaseException {
        cityService.saveCity(cityEntity);
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody CityEntity cityEntity) throws BaseException {
        cityService.updateCity(cityEntity);
    }

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") int id) throws BaseException {
        cityService.deleteCity(id);
    }
}
