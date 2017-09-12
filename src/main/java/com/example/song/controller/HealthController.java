package com.example.song.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class HealthController implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("song", "SONG").build();
    }
}
