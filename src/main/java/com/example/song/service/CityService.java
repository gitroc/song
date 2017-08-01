package com.example.song.service;

import com.example.song.entity.CityEntity;

import java.util.List;

public interface CityService {
    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<CityEntity> findAllCity();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    CityEntity findCityById(int id);

    /**
     * 新增城市信息
     *
     * @param cityEntity
     * @return
     */
    void saveCity(CityEntity cityEntity);

    /**
     * 更新城市信息
     *
     * @param cityEntity
     * @return
     */
    void updateCity(CityEntity cityEntity);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    void deleteCity(int id);
}
