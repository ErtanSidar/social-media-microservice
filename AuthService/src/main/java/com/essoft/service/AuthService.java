package com.essoft.service;

import com.essoft.dto.request.CreateUserRequestDto;
import com.essoft.dto.request.LoginResponseDto;
import com.essoft.dto.request.RegisterRequestDto;
import com.essoft.entity.Auth;
import com.essoft.manager.UserProfileManager;
import com.essoft.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto registerRequestDto) {
        Auth auth = authRepository.save(Auth.builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(registerRequestDto.getPassword())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .username(auth.getUsername())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDto loginResponseDto) {
        return authRepository.existsByUsernameAndPassword(loginResponseDto.getUsername(), loginResponseDto.getPassword());
    }
}
