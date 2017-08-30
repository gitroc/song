package com.example.song.service.impl;

import com.example.song.dao.CompanyRepository;
import com.example.song.entity.CompanyEntity;
import com.example.song.entity.CompanyListEntity;
import com.example.song.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyListEntity findAll() {
        CompanyListEntity listEntity = new CompanyListEntity();
        listEntity.setList((List<CompanyEntity>) companyRepository.findAll());
        return listEntity;
    }

    @Override
    public CompanyEntity findById(int id) {
        return companyRepository.findOne(id);
    }

    @Override
    public CompanyEntity save(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    public CompanyEntity update(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    public void delete(int id) {
        companyRepository.delete(id);
    }
}
