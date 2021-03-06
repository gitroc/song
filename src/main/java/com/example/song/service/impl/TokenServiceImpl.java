package com.example.song.service.impl;

import com.example.song.dao.TokenRepository;
import com.example.song.entity.TokenEntity;
import com.example.song.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public TokenEntity getToken(String value) {
        return tokenRepository.findByValue(value);
    }
}
