package com.ratelimiting.Rate.Limiter.service;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterConfigService {

    private final RateLimiterRegistry rateLimiterRegistry;

    public RateLimiterConfigService(RateLimiterRegistry rateLimiterRegistry) {
        this.rateLimiterRegistry = rateLimiterRegistry;
    }

    public void updateRateLimiterConfig(String limiterName, int limit, int refreshPeriodSeconds) {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(limit)
                .limitRefreshPeriod(Duration.ofSeconds(refreshPeriodSeconds))
                .timeoutDuration(Duration.ofMillis(500))
                .build();

        RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter(limiterName, config);
        System.out.println("Updated rate limiter: " + rateLimiter.getName());
    }
}

