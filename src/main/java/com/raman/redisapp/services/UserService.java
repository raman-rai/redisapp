package com.raman.redisapp.services;

import com.raman.redisapp.repository.RedisCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private RedisCacheRepository redisCacheRepository;

    public String getUserContact(String userId) {
        return redisCacheRepository.get(userId);
    }

    public void updateUserContact(String userId, String phone) {
        redisCacheRepository.set(userId, phone);
    }

    public void updateUserContactWithTTL(String userId, String phone) {
        redisCacheRepository.setWithTTL(userId, phone, 5, TimeUnit.MINUTES);
    }
}
