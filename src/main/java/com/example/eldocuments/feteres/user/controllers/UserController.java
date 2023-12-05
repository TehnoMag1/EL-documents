package com.example.eldocuments.feteres.user.controllers;

import com.example.eldocuments.feteres.user.dto.security.JwtRequestDto;
import com.example.eldocuments.feteres.user.dto.security.JwtResponseDto;
import com.example.eldocuments.feteres.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    @PostMapping("login")
    private JwtResponseDto login(
            @RequestBody JwtRequestDto dto
    ) {
        return userService.login(dto);
    }
}
