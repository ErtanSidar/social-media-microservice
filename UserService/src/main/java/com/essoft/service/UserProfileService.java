package com.essoft.service;

import com.essoft.document.UserProfile;
import com.essoft.dto.request.CreateUserRequestDto;
import com.essoft.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final CacheManager cacheManager;

    public void createUser(CreateUserRequestDto createUserRequestDto) {
        userProfileRepository.save(UserProfile.builder()
                .authId(createUserRequestDto.getAuthId())
                .username(createUserRequestDto.getUsername())
                .email(createUserRequestDto.getEmail())
                .build());
    }


    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }

    // this is an example for redis
    @Cacheable("upper-name")
    public String upperName(String name) {
        String result = name.toUpperCase();
        return result;
    }

    public void clearCache() {
        cacheManager.getCache("upper-name").clear();
    }
}
