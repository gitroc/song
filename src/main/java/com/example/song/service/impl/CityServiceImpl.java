package com.example.song.service.impl;

import com.example.song.dao.CityRepository;
import com.example.song.entity.CityEntity;
import com.example.song.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<CityEntity> findAllCity(){
        return (List<CityEntity>)cityRepository.findAll();
    }

    public CityEntity findCityById(int id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void saveCity(CityEntity cityEntity) {
        cityRepository.save(cityEntity);
    }

    @Override
    public void updateCity(CityEntity cityEntity) {
        cityRepository.save(cityEntity);
    }

    @Override
    public void deleteCity(int id) {
        cityRepository.delete(id);
    }
}
