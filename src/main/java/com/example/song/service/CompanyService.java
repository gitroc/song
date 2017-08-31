package com.example.song.service;

import com.example.song.entity.CompanyEntity;

public interface CompanyService {
    Iterable<CompanyEntity> findAll();

    CompanyEntity findById(int id);

    CompanyEntity save(CompanyEntity companyEntity);

    CompanyEntity update(CompanyEntity companyEntity);

    void delete(int id);
}
