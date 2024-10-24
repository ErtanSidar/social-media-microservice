package com.essoft.service;

import com.essoft.dto.request.LoginResponseDto;
import com.essoft.dto.request.RegisterRequestDto;
import com.essoft.entity.Auth;
import com.essoft.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Auth register(RegisterRequestDto registerRequestDto) {
        return authRepository.save(Auth.builder()
                .username(registerRequestDto.getUsername())
                .email(registerRequestDto.getEmail())
                .password(registerRequestDto.getPassword())
                .build());
    }

    public Boolean login(LoginResponseDto loginResponseDto) {
        return authRepository.existsByUsernameAndPassword(loginResponseDto.getUsername(), loginResponseDto.getPassword());
    }
}
