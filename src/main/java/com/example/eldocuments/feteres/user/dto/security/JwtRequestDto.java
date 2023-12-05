package com.example.eldocuments.feteres.user.dto.security;

import jakarta.validation.constraints.NotNull;

public record JwtRequestDto(
        String uKey
) {}