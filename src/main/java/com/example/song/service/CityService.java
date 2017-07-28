package com.example.song.service;

import com.example.song.domain.City;

import java.util.List;

public interface CityService {
    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    City findCityById(int id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    void saveCity(City city);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    void updateCity(City city);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    void deleteCity(int id);
}
