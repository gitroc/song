package com.example.song.service;

import com.example.song.domain.TokenEntity;

public interface TokenService {
    TokenEntity getToken(String value);
}
