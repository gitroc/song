package com.example.song.service.impl;

import com.example.song.dao.CompanyRepository;
import com.example.song.entity.CompanyEntity;
import com.example.song.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "company")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Cacheable("companyList")
    public Iterable<CompanyEntity> findList(Pageable pageable) {
        return companyRepository.findAll(pageable).getContent();
    }

    @Override
    @Cacheable("oneCompany")
    public CompanyEntity findById(int id) {
        return companyRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = {"companyList", "oneCompany"}, allEntries = true)
    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    @CacheEvict(value = {"companyList", "oneCompany"}, allEntries = true)
    public Iterable<CompanyEntity> save(Iterable<CompanyEntity> list) {
        return companyRepository.save(list);
    }

    @Override
    @CacheEvict(value = {"companyList", "oneCompany"}, allEntries = true)
    public CompanyEntity update(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    @CacheEvict(value = {"companyList", "oneCompany"}, allEntries = true)
    public Iterable<CompanyEntity> update(Iterable<CompanyEntity> list) {
        return companyRepository.save(list);
    }

    @Override
    @CacheEvict(value = {"companyList", "oneCompany"}, allEntries = true)
    public void delete(int id) {
        companyRepository.delete(id);
    }
}
