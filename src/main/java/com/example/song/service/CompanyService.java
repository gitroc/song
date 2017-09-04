package com.example.song.service;

import com.example.song.entity.CompanyEntity;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    Iterable<CompanyEntity> findList(Pageable pageable);

    CompanyEntity findById(int id);

    CompanyEntity save(CompanyEntity companyEntity);

    Iterable<CompanyEntity> save(Iterable<CompanyEntity> list);

    CompanyEntity update(CompanyEntity companyEntity);

    Iterable<CompanyEntity> update(Iterable<CompanyEntity> list);

    void delete(int id);
}
