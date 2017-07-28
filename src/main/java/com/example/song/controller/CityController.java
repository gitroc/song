package com.example.song.controller;

import com.example.song.domain.City;
import com.example.song.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/web/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") int id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @RequestMapping(value = "/web/city", method = RequestMethod.GET)
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList", cityList);
        return "cityList";
    }
}
