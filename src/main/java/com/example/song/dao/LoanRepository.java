package com.example.song.dao;

import com.example.song.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoanRepository extends PagingAndSortingRepository<LoanEntity, Long>, JpaSpecificationExecutor<LoanEntity> {
}
