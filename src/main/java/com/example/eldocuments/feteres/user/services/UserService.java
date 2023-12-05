package com.example.eldocuments.feteres.user.services;

import com.example.eldocuments.common.exceptions.NotFoundException;
import com.example.eldocuments.feteres.user.dto.security.JwtRequestDto;
import com.example.eldocuments.feteres.user.dto.security.JwtResponseDto;
import com.example.eldocuments.feteres.user.entities.UKeyEntity;
import com.example.eldocuments.feteres.user.entities.UserEntity;
import com.example.eldocuments.feteres.user.repositories.UKeyRepository;
import com.example.eldocuments.feteres.user.repositories.UserRepository;
import com.example.eldocuments.feteres.user.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UKeyRepository uKeyRepository;

    @Lazy
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public JwtResponseDto login(JwtRequestDto dto) {
        JwtResponseDto jwtResponse = new JwtResponseDto();

        UKeyEntity user = getUKeyEntityByUKey(dto.uKey());

        String accessToken = jwtTokenProvider.createAccessToken(user.getId(), user.getUser().getFirstName(), user.getUser().getIsAdmin());
        jwtResponse.setUserId(user.getId());
        jwtResponse.setIsAdmin(user.getUser().getIsAdmin());
        jwtResponse.setAccessToken(accessToken);

        return jwtResponse;
    }

    public UserEntity getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UKeyEntity getUKeyEntityByUKey(String uKey) {
        return uKeyRepository.findByUkey(uKey)
                .orElseThrow(() -> new NotFoundException("UKey not found"));
    }
}
