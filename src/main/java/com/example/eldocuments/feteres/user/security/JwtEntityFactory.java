package com.example.eldocuments.feteres.user.security;

import com.example.eldocuments.feteres.user.entities.UserEntity;

public final class JwtEntityFactory {

    public static JwtEntity create(final String uKey, final UserEntity user) {
        return new JwtEntity(
                user.getId(),
                uKey,
                user.getIsAdmin()
        );
    }
}
