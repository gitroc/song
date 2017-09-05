package com.example.song.service.impl;

import com.example.song.dao.CompanyRepository;
import com.example.song.entity.CompanyEntity;
import com.example.song.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;

@Service
@CacheConfig(cacheNames = "company")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Cacheable("listByPage")
    public Iterable<CompanyEntity> findListByPage(Pageable pageable) {
        return companyRepository.findAll(pageable).getContent();
    }

    @Override
    @Cacheable("listByTime")
    public Iterable<CompanyEntity> findListByTime(Timestamp updateTime, Pageable pageable) {
        return companyRepository.findAll(new Specification<CompanyEntity>() {
            @Override
            public Predicate toPredicate(Root<CompanyEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (null != updateTime) {
                    criteriaQuery.where(criteriaBuilder.greaterThan(root.get("updateTime").as(Timestamp.class), updateTime));
                }
                return null;
            }
        }, pageable).getContent();
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
