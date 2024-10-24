package com.essoft.controller;

import com.essoft.dto.request.LoginResponseDto;
import com.essoft.dto.request.RegisterRequestDto;
import com.essoft.entity.Auth;
import com.essoft.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.essoft.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto registerRequestDto) {
        if (!registerRequestDto.getPassword().equals(registerRequestDto.getRepassword())) {
            throw new RuntimeException("Password does not match");
        }
        return ResponseEntity.ok(authService.register(registerRequestDto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDto loginResponseDto) {
        return ResponseEntity.ok(authService.login(loginResponseDto));
    }
}
