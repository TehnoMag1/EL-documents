package com.example.eldocuments.feteres.user.dto;

import com.example.eldocuments.feteres.doljnost.dto.DoljnostDto;
import com.example.eldocuments.feteres.doljnost.enitites.DoljnostEntity;
import com.example.eldocuments.feteres.user.entities.UserEntity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDetailsDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String midName;
    private String ukey;
    private LocalDate birthday;
    private Integer npassport;
    private Integer spassport;
    private DoljnostDto doljnost;

    public static UserDetailsDto create(UserEntity entity) {
        UserDetailsDto dto = new UserDetailsDto();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setMidName(entity.getMidName());

        if(entity.getUKey() != null) {
            dto.setUkey(entity.getUKey().getUkey());
        }

        if(entity.getDetails() != null) {
            dto.setBirthday(entity.getDetails().getBirthday());
            dto.setNpassport(entity.getDetails().getNPassport());
            dto.setSpassport(entity.getDetails().getSPassport());
            dto.setDoljnost(DoljnostDto.create(entity.getDetails().getDoljnost()));
        }

        return dto;
    }
}
