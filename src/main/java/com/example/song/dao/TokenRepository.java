package com.example.song.dao;

import com.example.song.domain.TokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TokenRepository extends CrudRepository<TokenEntity, Integer> {
    TokenEntity findByValue(String value);
}
