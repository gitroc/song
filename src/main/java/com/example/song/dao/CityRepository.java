package com.example.song.dao;

import com.example.song.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CityRepository extends CrudRepository<CityEntity, Integer> {
}
