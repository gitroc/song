package com.example.song.service.impl;

import com.example.song.dao.CityRepository;
import com.example.song.domain.City;
import com.example.song.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAllCity(){
        return (List<City>)cityRepository.findAll();
    }

    public City findCityById(int id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void saveCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public void updateCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public void deleteCity(int id) {
        cityRepository.delete(id);
    }
}
