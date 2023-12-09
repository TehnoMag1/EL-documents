package com.example.eldocuments.feteres.user.services;

import com.example.eldocuments.common.exceptions.NotFoundException;
import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;
import com.example.eldocuments.feteres.doljnost.services.DoljnostService;
import com.example.eldocuments.feteres.user.dto.CreateUserDetailsInfoParams;
import com.example.eldocuments.feteres.user.dto.CreateUserParams;
import com.example.eldocuments.feteres.user.dto.security.JwtRequestDto;
import com.example.eldocuments.feteres.user.dto.security.JwtResponseDto;
import com.example.eldocuments.feteres.user.entities.UKeyEntity;
import com.example.eldocuments.feteres.user.entities.UserDetailsInfoEntity;
import com.example.eldocuments.feteres.user.entities.UserEntity;
import com.example.eldocuments.feteres.user.repositories.UKeyRepository;
import com.example.eldocuments.feteres.user.repositories.UserDetailsInfoRepository;
import com.example.eldocuments.feteres.user.repositories.UserRepository;
import com.example.eldocuments.feteres.user.security.JwtEntity;
import com.example.eldocuments.feteres.user.security.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UKeyRepository uKeyRepository;
    private final UserDetailsInfoRepository userDetailsInfoRepository;

    private final DoljnostService doljnostService;

    @Lazy
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

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

    public JwtEntity getUserByAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  (JwtEntity) authentication.getPrincipal();
    }

    public Integer getUserIdByAuthentication() {
        return getUserByAuthentication().getId();
    }

    public Integer add(CreateUserParams params) {
        UserEntity user = new UserEntity();
        UKeyEntity uKey = new UKeyEntity();

        user.setMidName(params.getMidName());
        user.setLastName(params.getLastName());
        user.setFirstName(params.getFirstName());

        user = userRepository.save(user);

        uKey.setId(user.getId());
        uKey.setUkey(params.getUKey());
        uKey.setUser(user);

        uKeyRepository.save(uKey);

        return user.getId();
    }

    public Integer addDetails(Integer userId, CreateUserDetailsInfoParams params) {
        UserDetailsInfoEntity userDetailsInfo = new UserDetailsInfoEntity();
        DoljnostEntity doljnost = doljnostService.getById(params.getDoljnostId());
        UserEntity user = getById(userId);

        userDetailsInfo.setDoljnost(doljnost);
        userDetailsInfo.setBirthday(params.getBirthday());
        userDetailsInfo.setNPassport(params.getNPassport());
        userDetailsInfo.setSPassport(params.getSPassport());
        userDetailsInfo.setId(userId);
        userDetailsInfo.setUser(user);

        return userDetailsInfoRepository.save(userDetailsInfo).getId();
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
