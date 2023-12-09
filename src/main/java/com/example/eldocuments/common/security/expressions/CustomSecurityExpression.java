package com.example.eldocuments.common.security.expressions;

import com.example.eldocuments.feteres.user.security.JwtEntity;
import com.example.eldocuments.feteres.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomSecurityExpression {

    private final UserService userService;

    public boolean hasIsAdmin() {
        JwtEntity user = userService.getUserByAuthentication();
        return user.getIsAdmin();
    }
}
