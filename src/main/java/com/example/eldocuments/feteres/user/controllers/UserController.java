package com.example.eldocuments.feteres.user.controllers;

import com.example.eldocuments.common.exceptions.ForbiddenException;
import com.example.eldocuments.common.security.expressions.CustomSecurityExpression;
import com.example.eldocuments.feteres.user.dto.CreateUserDetailsInfoParams;
import com.example.eldocuments.feteres.user.dto.CreateOrUpdateUserParams;
import com.example.eldocuments.feteres.user.dto.UserDetailsDto;
import com.example.eldocuments.feteres.user.dto.UserDto;
import com.example.eldocuments.feteres.user.dto.security.JwtRequestDto;
import com.example.eldocuments.feteres.user.dto.security.JwtResponseDto;
import com.example.eldocuments.feteres.user.entities.UserEntity;
import com.example.eldocuments.feteres.user.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    private final CustomSecurityExpression customSecurityExpression;

    @PostMapping("login")
    private JwtResponseDto login(
            @RequestBody JwtRequestDto dto
    ) {
        return userService.login(dto);
    }

    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    private List<UserDto> getAll() {
        if(!customSecurityExpression.hasIsAdmin())
            throw new ForbiddenException();

        return userService.getAll().stream().map(UserDto::create).toList();
    }

    @GetMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    private UserDetailsDto getById(@PathVariable Integer id) {
        return UserDetailsDto.create(userService.getById(id));
    }

    @GetMapping("me")
    @SecurityRequirement(name = "bearerAuth")
    private UserDetailsDto me() {
        Integer userId = userService.getUserIdByAuthentication();
        return UserDetailsDto.create(userService.getById(userId));
    }

    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    private Integer add(@RequestBody CreateOrUpdateUserParams params) {

        if(!customSecurityExpression.hasIsAdmin())
            throw new ForbiddenException();

        return userService.add(params);
    }

    @PutMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    private void update(
            @PathVariable Integer id,
            @RequestBody CreateOrUpdateUserParams params
    ) {

        if(!customSecurityExpression.hasIsAdmin())
            throw new ForbiddenException();

        userService.update(id, params);
    }

    @PostMapping("{id}/details")
    @SecurityRequirement(name = "bearerAuth")
    private Integer addDetails(
            @PathVariable Integer id,
            @RequestBody CreateUserDetailsInfoParams params
    ) {
        if(!customSecurityExpression.hasIsAdmin())
            throw new ForbiddenException();

        return userService.addDetails(id, params);
    }

    @DeleteMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    private void deleteById(@PathVariable Integer id) {

        if(!customSecurityExpression.hasIsAdmin())
            throw new ForbiddenException();

        userService.deleteById(id);
    }
}
