package com.example.eldocuments.feteres.user.security;

import com.example.eldocuments.feteres.user.entities.UserEntity;
import com.example.eldocuments.feteres.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService {

    private final UserService userService;

    public UserDetails getUserDetailsById(final Integer id) throws UsernameNotFoundException {
        UserEntity user = userService.getById(id);
        return JwtEntityFactory.create(user.getUKey().getUkey(), user);
    }

}
