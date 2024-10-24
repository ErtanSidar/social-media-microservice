package com.essoft.manager;

import com.essoft.dto.request.CreateUserRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.essoft.config.RestApis.CREATE_USER;

@FeignClient(url = "http://localhost:9091/dev/v1/user-profile", name = "userProfileManager")
public interface UserProfileManager {
    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto createUserRequestDto);
}
