package com.example.song.service;

import com.example.song.entity.LoanEntity;
import org.springframework.data.domain.Pageable;

public interface LoanService {
    Iterable<LoanEntity> findListByPage(Pageable pageable);

    Iterable<LoanEntity> findListByLimit(long loanLimit, Pageable pageable);

    LoanEntity findById(long id);

    LoanEntity save(LoanEntity loanEntity);

    Iterable<LoanEntity> save(Iterable<LoanEntity> list);

    LoanEntity update(LoanEntity loanEntity);

    Iterable<LoanEntity> update(Iterable<LoanEntity> list);

    void delete(long id);
}
