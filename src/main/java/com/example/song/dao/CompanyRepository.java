package com.example.song.dao;

import com.example.song.entity.CompanyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CompanyRepository extends PagingAndSortingRepository<CompanyEntity, Integer> {

}
