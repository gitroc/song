package com.example.song.service.impl;

import com.example.song.dao.LoanRepository;
import com.example.song.entity.LoanEntity;
import com.example.song.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "loan")
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    @Cacheable(value = "loanListByPage")
    public Iterable<LoanEntity> findListByPage(Pageable pageable) {
        return loanRepository.findAll(pageable).getContent();
    }

    @Override
    @Cacheable(value = "findListByLimit")
    public Iterable<LoanEntity> findListByLimit(long loanLimit, Pageable pageable) {
        return loanRepository.findAll(
                (root, criteriaQuery, criteriaBuilder) -> {
                    if (0 != loanLimit) {
                        criteriaQuery.where(criteriaBuilder.lessThan(root.get("loanLimit").as(Long.class), loanLimit));
                    }
                    return null;
                }, pageable).getContent();
    }

    @Override
    @Cacheable(value = "loanById")
    public LoanEntity findById(long id) {
        return loanRepository.findOne(id);
    }

    @Override
    @CacheEvict(value = {"loanListByPage", "findListByLimit", "loanById"}, allEntries = true)
    public LoanEntity save(LoanEntity loanEntity) {
        return loanRepository.save(loanEntity);
    }

    @Override
    @CacheEvict(value = {"loanListByPage", "findListByLimit", "loanById"}, allEntries = true)
    public Iterable<LoanEntity> save(Iterable<LoanEntity> list) {
        return loanRepository.save(list);
    }

    @Override
    @CacheEvict(value = {"loanListByPage", "findListByLimit", "loanById"}, allEntries = true)
    public LoanEntity update(LoanEntity loanEntity) {
        return loanRepository.save(loanEntity);
    }

    @Override
    @CacheEvict(value = {"loanListByPage", "findListByLimit", "loanById"}, allEntries = true)
    public Iterable<LoanEntity> update(Iterable<LoanEntity> list) {
        return loanRepository.save(list);
    }

    @Override
    @CacheEvict(value = {"loanListByPage", "findListByLimit", "loanById"}, allEntries = true)
    public void delete(long id) {
        loanRepository.delete(id);
    }
}
