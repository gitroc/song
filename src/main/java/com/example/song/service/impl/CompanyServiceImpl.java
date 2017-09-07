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

import java.sql.Timestamp;

@Service
@CacheConfig(cacheNames = "company")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Cacheable("companyListByPage")
    public Iterable<CompanyEntity> findListByPage(Pageable pageable) {
        return companyRepository.findAll(pageable).getContent();
    }

    @Override
    @Cacheable("companyListByTime")
    public Iterable<CompanyEntity> findListByTime(Timestamp updateTime, Pageable pageable) {
        /***
         * java 8 lambda 表达式, Roc 第二次试用
         */
        return companyRepository.findAll(
                (root, criteriaQuery, criteriaBuilder) -> {
                    if (null != updateTime) {
                        criteriaQuery.where(criteriaBuilder.greaterThan(root.get("updateTime").as(Timestamp.class), updateTime));
                    }
                    return null;
                }, pageable).getContent();
    }

    @Override
    @Cacheable("companyById")
    public CompanyEntity findById(int id) {
        return companyRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = {"companyListByPage", "companyListByTime", "companyById"}, allEntries = true)
    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    @CacheEvict(value = {"companyListByPage", "companyListByTime", "companyById"}, allEntries = true)
    public Iterable<CompanyEntity> save(Iterable<CompanyEntity> list) {
        return companyRepository.save(list);
    }

    @Override
    @CacheEvict(value = {"companyListByPage", "companyListByTime", "companyById"}, allEntries = true)
    public CompanyEntity update(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    @CacheEvict(value = {"companyListByPage", "companyListByTime", "companyById"}, allEntries = true)
    public Iterable<CompanyEntity> update(Iterable<CompanyEntity> list) {
        return companyRepository.save(list);
    }

    @Override
    @CacheEvict(value = {"companyListByPage", "companyListByTime", "companyById"}, allEntries = true)
    public void delete(int id) {
        companyRepository.delete(id);
    }
}
