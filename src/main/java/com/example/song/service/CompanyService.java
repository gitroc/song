package com.example.song.service;

import com.example.song.entity.CompanyEntity;
import com.example.song.entity.CompanyListEntity;

public interface CompanyService {
    CompanyListEntity findAll();

    CompanyEntity findById(int id);

    CompanyEntity save(CompanyEntity companyEntity);

    CompanyEntity update(CompanyEntity companyEntity);

    void delete(int id);
}
