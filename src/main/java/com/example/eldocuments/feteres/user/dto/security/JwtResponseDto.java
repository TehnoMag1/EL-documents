package com.example.eldocuments.feteres.user.dto.security;

import lombok.Data;

@Data
public class JwtResponseDto {

    private Integer userId;
    private Boolean isAdmin;
    private String accessToken;
}