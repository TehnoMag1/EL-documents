package com.example.eldocuments.feteres.user.dto;

import com.example.eldocuments.feteres.user.entities.UserEntity;
import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String midName;

    public static UserDto create(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMidName(user.getMidName());
        return userDto;
    }
}
