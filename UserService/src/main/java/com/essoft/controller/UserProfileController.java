package com.essoft.controller;

import com.essoft.document.UserProfile;
import com.essoft.dto.request.CreateUserRequestDto;
import com.essoft.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.essoft.config.RestApis.*;

@RestController
@RequestMapping(USERPROFILE)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        userProfileService.createUser(createUserRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(userProfileService.getAll());
    }

    @GetMapping
    public ResponseEntity<String> upperName(String name) {
        return ResponseEntity.ok(userProfileService.upperName(name));
    }
}
