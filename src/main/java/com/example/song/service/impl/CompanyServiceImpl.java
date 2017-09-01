package com.example.song.service.impl;

import com.example.song.dao.CompanyRepository;
import com.example.song.entity.CompanyEntity;
import com.example.song.service.CompanyService;
import com.example.song.utils.ViewFlipperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "company")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Cacheable("companyList")
    public Iterable<CompanyEntity> findAll() {
        return companyRepository.findAll();
    }

    @Override
    @Cacheable("findCompany")
    public CompanyEntity findById(int id) {
        return companyRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = {"companyList", "findCompany"}, allEntries = true)
    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    @CacheEvict(value = {"companyList", "findCompany"}, allEntries = true)
    public CompanyEntity update(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    @CacheEvict(value = {"companyList", "findCompany"}, allEntries = true)
    public void delete(int id) {
        companyRepository.delete(id);
    }
}
